package com.example.demo_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Book;
import com.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    public Book addBook(Book book) {
        return repository.save(book);
    }
    public List<Book> getBooks() {
        return repository.findAll();
    }
    public Book getBook(Long id) {
        // Implementation for getting a specific book
        return repository.findById(id).orElse(null);
    }
    public Book updateBook(Long id, Book updateBook) {

    Book existingBook = repository.findById(id).orElse(null);

    if (existingBook == null) {
        return null;
    }

    existingBook.setTitle(updateBook.getTitle());
    existingBook.setAuthor(updateBook.getAuthor());
    existingBook.setPrice(updateBook.getPrice());

    return repository.save(existingBook);
}
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
