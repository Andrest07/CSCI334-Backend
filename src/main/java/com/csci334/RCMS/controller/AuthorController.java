package com.csci334.RCMS.controller;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){ this.authorService = authorService; }

    @GetMapping("/author/{id}")
    Author getAuthorById(@PathVariable Long id) throws Exception {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/createAuthor")
    Author createAuthor(@RequestBody Author newAuthor) {
        return authorService.createAuthor(newAuthor);
    }

    @PutMapping("/updateAuthor/{id}")
    Author updateAuthor(@RequestBody Author author, @PathVariable Long id) throws Exception {
        return authorService.updateAuthor(author, id);
    }

    @DeleteMapping({"/deleteAuthor/{id}"})
    void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
