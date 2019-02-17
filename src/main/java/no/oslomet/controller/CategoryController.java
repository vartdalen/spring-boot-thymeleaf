package no.oslomet.controller;

import no.oslomet.model.Category;
import no.oslomet.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    @Transactional
    public String categories(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

    @PostMapping("")
    @Transactional
    public String categories(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    @RequestMapping("/category")
    @Transactional
    public String category(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category";
    }

    @RequestMapping("/category/{id}")
    @Transactional
    public String updateCategory(Model model, @PathVariable("id") String id) {
        Category category = new Category();
        category = categoryRepository.findById(Long.parseLong(id)).get();
        model.addAttribute("category", category);
        return "category";
    }

    @RequestMapping("/update/{id}")
    @Transactional
    public String update(@PathVariable("id") String id, String name) {
        Category category = new Category();
        category = categoryRepository.findById(Long.parseLong(id)).get();
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    @RequestMapping("/delete/{id}")
    @Transactional
    public String delete(@PathVariable("id") String id) {
        Category category = new Category();
        category = categoryRepository.findById(Long.parseLong(id)).get();
        categoryRepository.delete(category);
        return "redirect:/categories";
    }
}
