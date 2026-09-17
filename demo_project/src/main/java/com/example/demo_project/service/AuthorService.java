package com.example.demo_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Author;
import com.repository.AuthorRepo;

@Service
public class AuthorService {

    private final AuthorRepo repository;

    public AuthorService(AuthorRepo repository) {
        this.repository = repository;
    }

    // POST - Add Author
    public Author addAuthor(Author author) {
        return repository.save(author);
    }

    // GET - Get all Authors
    public List<Author> getAuthors() {
        return repository.findAll();
    }

    // GET - Get Author by ID
    public Author getAuthor(Long id) {
        return repository.findById(id).orElse(null);
    }

    // PUT - Update Author
    public Author updateAuthor(Long id, Author updateAuthor) {

        Author existingAuthor = repository.findById(id).orElse(null);

        if (existingAuthor == null) {
            return null;
        }

        existingAuthor.setName(updateAuthor.getName());
        existingAuthor.setCountry(updateAuthor.getCountry());

        return repository.save(existingAuthor);
    }

    // DELETE - Delete Author
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }
}