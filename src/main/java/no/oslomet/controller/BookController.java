package no.oslomet.controller;

import no.oslomet.model.Author;
import no.oslomet.model.Book;
import no.oslomet.model.Category;
import no.oslomet.repository.AuthorRepository;
import no.oslomet.repository.BookRepository;
import no.oslomet.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    // Dependency injection
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    @Transactional
    public String books(Model model){
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("books", bookList);
        return "books";
    }

    @PostMapping("")
    @Transactional
    public String books(@ModelAttribute("book") Book book, @RequestParam("idCategory") String idCategory, @RequestParam("idAuthor") String idAuthor){
        Author author = new Author();
        author = authorRepository.findById(Long.parseLong(idAuthor)).get();
        book.setAuthor(author);
        Category category = new Category();
        category = categoryRepository.findById(Long.parseLong(idCategory)).get();
        book.setCategory(category);
        bookRepository.save(book);
        return "redirect:/books";
    }

    @RequestMapping("/book")
    @Transactional
    public String book(Model model){
        Book book = new Book();
        List<Author> authorList = authorRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("book", book);
        model.addAttribute("authors", authorList);
        model.addAttribute("categories", categoryList);
        return "book";
    }

    @RequestMapping("/book/{id}")
    @Transactional
    public String updateBook(Model model, @PathVariable("id") String id){
        Book book = new Book();
        book = bookRepository.findById(Long.parseLong(id)).get();
        List<Author> authorList = authorRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("book", book);
        model.addAttribute("authors", authorList);
        model.addAttribute("categories", categoryList);
        return "book";
    }

    @RequestMapping("/update/{id}")
    @Transactional
    public String update(@PathVariable("id") String id, String title, String releaseYear, Category category, Author author){
        Book book = new Book();
        book = bookRepository.findById(Long.parseLong(id)).get();
        book.setTitle(title);
        book.setReleaseYear(releaseYear);
        book.setCategory(category);
        book.setAuthor(author);
        bookRepository.save(book);
        return "redirect:/books";
    }

    @RequestMapping("/delete/{id}")
    @Transactional
    public String delete(@PathVariable("id") String id){
        Book book = new Book();
        book = bookRepository.findById(Long.parseLong(id)).get();
        bookRepository.delete(book);
        return "redirect:/books";
    }
}