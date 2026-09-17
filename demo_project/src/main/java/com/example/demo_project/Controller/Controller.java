package com.example.demo_project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.service.BookService;
import com.model.Book;
 
@RestController
@RequestMapping("/books")
public class Controller {
    private final BookService service;

    public Controller(BookService service) {
        this.service = service;
    }

   @GetMapping
public List<Book> getBooks() {
    return service.getBooks();
}

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }
    @PutMapping("/{id}")
public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
    return service.updateBook(id, book);
}
   @DeleteMapping("/{id}")
public void deleteBook(@PathVariable Long id) {
    service.deleteBook(id);
}
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return service.getBook(id);
    }
    
}
    