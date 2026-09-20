package com.example.demo_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo_project.service.AuthorService;
import com.example.demo_project.service.BookService;
import com.model.Author;
import com.model.Book;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/books")
public class BookWebController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookWebController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "Book";
    }

    @GetMapping("/new")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAuthors());
        return "AddBook";
    }

    @PostMapping("/save")
    public String saveBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult result,
            @RequestParam Long authorId,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("authors", authorService.getAuthors());
            return "AddBook";
        }

        Author author = authorService.getAuthor(authorId);
        book.setAuthor(author);
        bookService.addBook(book);
        return "redirect:/api/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAuthors());
        return "EditBook";
    }

    @PostMapping("/update/{id}")
    public String updateBook(
            @PathVariable Long id,
            @Valid @ModelAttribute("book") Book book,
            BindingResult result,
            @RequestParam Long authorId,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("authors", authorService.getAuthors());
            return "EditBook";
        }

        Author author = authorService.getAuthor(authorId);
        book.setAuthor(author);
        bookService.updateBook(id, book);
        return "redirect:/api/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/api/books";
    }
}

