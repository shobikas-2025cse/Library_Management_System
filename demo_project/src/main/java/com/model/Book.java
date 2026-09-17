package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    // 1. Changed variables to private for safe encapsulation
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int price;

    // Default Constructor
    public Book() {
        this.title = "";
        this.author = "";
        this.price = 0;

    }

    // Parameterized Constructor
    public Book(String title, String author, int price) {
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
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Price Methods
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        // Benefit of setters: You can protect your data!
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative!");
        }
    }
}
