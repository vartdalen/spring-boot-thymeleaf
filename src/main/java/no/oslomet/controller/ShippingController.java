package no.oslomet.controller;

import no.oslomet.model.Shipping;
import no.oslomet.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/shippings")
public class ShippingController {
    @Autowired
    private ShippingRepository shippingRepository;

    @GetMapping("")
    @Transactional
    public String shippings(Model model) {
        List<Shipping> shippingList = shippingRepository.findAll();
        model.addAttribute("shippings", shippingList);
        return "shippings";
    }

    @PostMapping("")
    @Transactional
    public String shippings(@ModelAttribute("shipping") Shipping shipping) {
        shippingRepository.save(shipping);
        return "redirect:/shippings";
    }

    @RequestMapping("/shipping")
    @Transactional
    public String shipping(Model model) {
        Shipping shipping = new Shipping();
        model.addAttribute("shipping", shipping);
        return "shipping";
    }

    @RequestMapping("/shipping/{id}")
    @Transactional
    public String updateShipping(Model model, @PathVariable("id") String id) {
        Shipping shipping = new Shipping();
        shipping = shippingRepository.findById(Long.parseLong(id)).get();
        model.addAttribute("shipping", shipping);
        return "shipping";
    }

    @RequestMapping("/update/{id}")
    @Transactional
    public String update(@PathVariable("id") String id, String firstName, String lastName, String address, String postalCode) {
        Shipping shipping = new Shipping();
        shipping = shippingRepository.findById(Long.parseLong(id)).get();
        shipping.setFirstName(firstName);
        shipping.setLastName(lastName);
        shipping.setAddress(address);
        shipping.setPostalCode(Integer.parseInt(postalCode));
        shippingRepository.save(shipping);
        return "redirect:/shippings";
    }

    @RequestMapping("/delete/{id}")
    @Transactional
    public String delete(@PathVariable("id") String id) {
        Shipping shipping = new Shipping();
        shipping = shippingRepository.findById(Long.parseLong(id)).get();
        shippingRepository.delete(shipping);
        return "redirect:/shippings";
    }
}
