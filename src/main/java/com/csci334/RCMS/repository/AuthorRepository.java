package com.csci334.RCMS.repository;

import com.csci334.RCMS.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByUsername(String s);
    Optional<Author> findByPassword(String s);
}
