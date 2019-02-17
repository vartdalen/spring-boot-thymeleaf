package no.oslomet.controller;

import no.oslomet.model.*;
import no.oslomet.repository.BookRepository;
import no.oslomet.repository.OrderRepository;
import no.oslomet.repository.OrderlineRepository;
import no.oslomet.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ShippingRepository shippingRepository;
    @Autowired
    private OrderlineRepository orderlineRepository;

    @GetMapping("")
    @Transactional
    public String orders(Model model) {
        List<Order> orderList = orderRepository.findAll();
        List<Orderline> orderlineList = orderlineRepository.findAll();
        model.addAttribute("orders", orderList);
        model.addAttribute("orderlines", orderlineList);
        return "orders";
    }

    @PostMapping("")
    @Transactional
    public String orders(@ModelAttribute("order") Order order, @ModelAttribute BookForm bookForm, @RequestParam("idShipping") String idShipping) {
        Shipping shipping = new Shipping();
        shipping = shippingRepository.findById(Long.parseLong(idShipping)).get();
        order.setShipping(shipping);

        for (Book book : bookForm.getBookList()) {
            book = bookRepository.findById(book.getId()).get();
            book.setQuantity(book.getQuantity()-1);
            bookRepository.save(book);

            Orderline orderline = new Orderline();
            orderline.setOrder(order);
            orderline.setBook(book);
            orderlineRepository.save(orderline);
        }

        orderRepository.save(order);
        return "redirect:/orders";
    }

    @RequestMapping("/order")
    @Transactional
    public String order(Model model, String id) {
        Order order = new Order();
        if(id != null) {
            order = orderRepository.findById(Long.parseLong(id)).get();
        }
        List<Book> bookList = bookRepository.findAll();
        BookForm bookForm = new BookForm();
        bookForm.setBookList((ArrayList<Book>) bookList);

        List<Shipping> shippingList = shippingRepository.findAll();
        model.addAttribute("order", order);
        model.addAttribute("bookForm", bookForm);
        model.addAttribute("shippings", shippingList);
        return "order";
    }

    @RequestMapping("/order/{id}")
    @Transactional
    public String updateOrder(Model model, @PathVariable("id") String id) {
        order(model, id);
        return "order";
    }

    @RequestMapping("/update/{id}")
    @Transactional
    public String update(@PathVariable("idOrder") String idOrder, String date, @ModelAttribute BookForm bookForm, Shipping shipping) {
        Order order = new Order();
        order = orderRepository.findById(Long.parseLong(idOrder)).get();
        order.setDate(date);
        order.setShipping(shipping);

        List<Orderline> orderlineList = orderlineRepository.findAll();
        List<Book> bookList = bookRepository.findAll();
        for(Orderline orderline : orderlineList) {
            if(orderline.getOrder().getId() == order.getId()) {
                for (Book book : bookList) {
                    if (book.getId() == orderline.getBook().getId()) {
                        orderline.setId(orderline.getId());
                        orderline.setBook(book);
                        orderlineRepository.save(orderline);
                    }
                }
            }
        }

        orderRepository.save(order);
        return "redirect:/order";
    }

    @RequestMapping("/delete/{id}")
    @Transactional
    public String delete(@PathVariable("id") String id) {
        Order order = new Order();
        order = orderRepository.findById(Long.parseLong(id)).get();
        List<Orderline> orderlineList = orderlineRepository.findAll();
        for (Orderline orderline : orderlineList) {
            if(orderline.getOrder().getId() == order.getId()) {
                orderlineRepository.delete(orderline);
            }
        }
        orderRepository.delete(order);
        return "redirect:/orders";
    }
}
