package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Book {
    // 1. Changed variables to private for safe encapsulation
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @ManyToOne 
    @JoinColumn(name = "author_id")
    private Author author;
    @NotNull(message = "Price cannot be null")
    private Double price;

    // Default Constructor
    public Book() {
        this.title = "";
        this.author = null;
        this.price = 0.0;

    }

    // Parameterized Constructor
    public Book(String title, Author author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // 2. GETTERS & SETTERS

    public Long getId() {
        return this.id;
    }

    // Title Methods
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Author Methods
    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    // Price Methods
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        // Benefit of setters: You can protect your data!
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative!");
        }
    }

}
