package com.csci334.RCMS.database;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Paper;
import com.csci334.RCMS.repository.AuthorRepository;
import com.csci334.RCMS.repository.ConferenceRepository;
import com.csci334.RCMS.repository.PaperRepository;
import com.csci334.RCMS.repository.ReviewerRepository;
import com.csci334.RCMS.repository.SystemAdminRepository;
import com.csci334.RCMS.service.AuthorService;
import com.csci334.RCMS.service.PaperService;

@Configuration
class LoadDatabase {
    
    @Autowired
	AuthorService authorService;

    @Autowired
    PaperService paperService;

    @Bean
    CommandLineRunner initDatabase(AuthorRepository aRepository, ConferenceRepository cRepository, PaperRepository pRepository, ReviewerRepository rRepository, SystemAdminRepository sRepository, RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        Logger log = LoggerFactory.getLogger(LoadDatabase.class);
        Random random = new Random();
        
        return args -> {
            // authorService.createAuthor(new Author("Andreas", "ast", "123"));
            // paperService.createPaper(new Paper(5, "Poggers", true, "p", "p"));
            // authorService.addAuthorPaper(1L,1L);
        };
    }
}