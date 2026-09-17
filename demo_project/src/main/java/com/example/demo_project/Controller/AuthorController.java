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

import com.example.demo_project.service.AuthorService;
import com.model.Author;
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // POST - Add Author
    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    // GET - Get all Authors
    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    // GET - Get Author by ID
    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }

    // PUT - Update Author
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author updateAuthor) {
        return authorService.updateAuthor(id, updateAuthor);
    }

    // DELETE - Delete Author
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
