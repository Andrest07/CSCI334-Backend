package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Paper;
import com.csci334.RCMS.repository.AuthorRepository;
import com.csci334.RCMS.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) { this.authorRepository = authorRepository; }

    public Author getAuthorById(Long id) throws Exception{
        return authorRepository.findById(id).orElseThrow();
    }

    public Author createAuthor(Author newAuthor) {
        return authorRepository.save(newAuthor);
    }

    public Author updateAuthor(Author author, Long id) throws Exception {
        Author foundAuthor = getAuthorById(id);
        if (foundAuthor == null) {
            throw new Exception("Author invalid");
        }
        foundAuthor.setAuthor(author);
        return authorRepository.save(foundAuthor);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
