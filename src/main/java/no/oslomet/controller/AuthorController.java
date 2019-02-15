package no.oslomet.controller;

import no.oslomet.model.Author;
import no.oslomet.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    // Dependency injection
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("")
    @Transactional
    public String authors(Model model){
        List<Author> authorList = authorRepository.findAll();
        model.addAttribute("authors", authorList);
        return "authors";
    }

    @PostMapping("")
    @Transactional
    public String authors(@ModelAttribute("author") Author author){
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @RequestMapping("/author")
    @Transactional
    public String author(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "author";
    }

    //redirect to form to update author
    @RequestMapping("/author/{id}")
    @Transactional
    public String author(Model model, @PathVariable("id") String id){
        Author author = new Author();
        author = authorRepository.findById(Long.parseLong(id)).get();
        model.addAttribute("author", author);
        return "author";
    }

    @RequestMapping("/update/{id}")
    @Transactional
    public String update(@PathVariable("id") String id, String firstName, String lastName, String nationality){
        Author author = new Author();
        author = authorRepository.findById(Long.parseLong(id)).get();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setNationality(nationality);
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @RequestMapping("/delete/{id}")
    @Transactional
    public String delete(@PathVariable("id") String id){
        Author author = new Author();
        author = authorRepository.findById(Long.parseLong(id)).get();
        authorRepository.delete(author);
        return "redirect:/authors";
    }
}
