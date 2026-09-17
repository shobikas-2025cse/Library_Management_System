package com.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity 
public  class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
//default constructor
    public Author() {
        this.name = "";
        this.country = "";
    }
    public Author(String name, String country) {
        this.name = name;
        this.country = country;
    }
    // Getters and Setters
    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getCountry() {
        return this.country;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
