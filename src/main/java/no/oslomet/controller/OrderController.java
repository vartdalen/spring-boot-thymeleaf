package no.oslomet.controller;

import no.oslomet.model.Book;
import no.oslomet.model.Order;
import no.oslomet.repository.BookRepository;
import no.oslomet.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    // Dependency injection
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("")
    @Transactional
    public String orders(Model model) {
        List<Order> orderList = orderRepository.findAll();
        model.addAttribute("orders", orderList);
        return "orders";
    }

    @PostMapping("")
    @Transactional
    public String orders(@ModelAttribute("order") Order order, @RequestParam("idBook") String idBook) {
        Book book = new Book();
        book = bookRepository.findById(Long.parseLong(idBook)).get();
        order.setBook(book);

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
        model.addAttribute("order", order);
        model.addAttribute("books", bookList);
        return "order";
    }

    @RequestMapping("/order/{id}")
    @Transactional
    public String updateBook(Model model, @PathVariable("id") String id) {
        order(model, id);
        return "order";
    }

    @RequestMapping("/update/{id}")
    @Transactional
    public String update(@PathVariable("id") String id, String date, Book book) {
        Order order = new Order();
        order = orderRepository.findById(Long.parseLong(id)).get();
        order.setDate(date);
        order.setBook(book);
        orderRepository.save(order);
        return "redirect:/order";
    }

    @RequestMapping("/delete/{id}")
    @Transactional
    public String delete(@PathVariable("id") String id) {
        Order order = new Order();
        order = orderRepository.findById(Long.parseLong(id)).get();
        orderRepository.delete(order);
        return "redirect:/orders";
    }
}
