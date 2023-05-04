package com.csci334.RCMS.controller;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.service.AuthorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){ this.authorService = authorService; }

	@GetMapping("/authors")
	List<Author> all() {
		return authorService.getAuthors();
	}

	@GetMapping("/authors/ids")
	List<Long> getAuthorIds(){
		return authorService.getAuthorIds();
	}
    
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
    void deleteAuthor(@PathVariable Long id) throws Exception {
        authorService.deleteAuthor(id);
    }

    @PutMapping("/addAuthorPaper/{aId}/{pId}")
	Author putAuthorPaper(@PathVariable Long aId, @PathVariable Long pId) throws Exception {
		return authorService.addAuthorPaper(aId, pId);
	}
}
