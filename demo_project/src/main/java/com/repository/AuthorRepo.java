package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Author;
public interface AuthorRepo extends JpaRepository<Author, Long> {
    
}
