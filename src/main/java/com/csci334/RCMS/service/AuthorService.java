package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Paper;
import com.csci334.RCMS.repository.AuthorRepository;
import com.csci334.RCMS.repository.PaperRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    Logger log = LoggerFactory.getLogger(AuthorService.class);

    public AuthorService(AuthorRepository authorRepository) { this.authorRepository = authorRepository; }

    public Author getAuthorById(Long id) throws Exception{
        return authorRepository.findById(id).orElseThrow();
    }

    public Author createAuthor(Author newAuthor) {
        log.info("Creating Author: " + newAuthor);
        return authorRepository.save(newAuthor);
    }

    public Author updateAuthor(Author author, Long id) throws Exception {
        Author foundAuthor = getAuthorById(id);
        if (foundAuthor == null) {
            throw new Exception("Author invalid");
        }
        foundAuthor.setAuthor(author);
        log.info("Updating Author: " + foundAuthor);
        return authorRepository.save(foundAuthor);
    }

    public void deleteAuthor(Long id) throws Exception {
        log.info("Deleting Author: " + getAuthorById(id));
        authorRepository.deleteById(id);
    }

    public Author addAuthorPaper(Long aId, Long pId) throws Exception {
        Author a = getAuthorById(aId);
        a.addPaperId(pId);
        log.info("Adding Paper to Author: " + a);
        return authorRepository.save(a);
    }
}
