package com.example.demo_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_project.service.AuthorService;
import com.model.Author;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/authors")
public class AuthorWebController {

    private final AuthorService authorService;

    public AuthorWebController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String showAuthors(Model model) {
        model.addAttribute("authors", authorService.getAuthors());
        return "Author";
    }

    @GetMapping("/new")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "AddAuthor";
    }

    @PostMapping("/save")
    public String saveAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "AddAuthor";
        }

        authorService.addAuthor(author);
        return "redirect:/api/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Author author = authorService.getAuthor(id);
        model.addAttribute("author", author);
        return "EditAuthor";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id,
                              @Valid @ModelAttribute("author") Author author,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "EditAuthor";
        }

        authorService.updateAuthor(id, author);
        return "redirect:/api/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/api/authors";
    }
}
