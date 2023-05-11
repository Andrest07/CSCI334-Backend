package com.csci334.RCMS.service;

import com.csci334.RCMS.exceptions.CustomException;
import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    Logger log = LoggerFactory.getLogger(AuthorService.class);

    public AuthorService(AuthorRepository authorRepository) { this.authorRepository = authorRepository; }

	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	public List<Long> getAuthorIds() {
		List<Long> ids = new ArrayList<Long>();
		List<Author> authors = getAuthors();
		for(int i=0;i<authors.size();i++) {
			ids.add(authors.get(i).getId());
		}
		return ids;
	}

    public Author getAuthorById(Long id) throws Exception{
        return authorRepository.findById(id).orElseThrow();
    }

    public Author createAuthor(Author newAuthor) {
        try {
            return authorRepository.save(newAuthor);
        } finally {
            log.info("Creating Author: " + newAuthor);
        }
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

    public Author getAuthorFindUsername(String username) throws Exception{
        if(authorRepository.findByUsername(username).isPresent()) {
            return authorRepository.findByUsername(username).orElseThrow(() -> new Exception("Cannot find username"));
        }else{
            throw new CustomException("Incorrect Username or Password");
        }
    }

    public Author getAuthorFindPassword(String password) throws Exception{
        if(authorRepository.findByPassword(password).isPresent()) {
            return authorRepository.findByPassword(password).orElseThrow(() -> new Exception("Cannot find password"));
        }else{
            throw new CustomException("Incorrect Username or Password");
        }
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
