package com.csci334.RCMS.database;

import java.util.List;
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
import com.csci334.RCMS.model.Conference;
import com.csci334.RCMS.model.Paper;
import com.csci334.RCMS.model.Reviewer;
import com.csci334.RCMS.model.SystemAdmin;
import com.csci334.RCMS.repository.AuthorRepository;
import com.csci334.RCMS.repository.ConferenceRepository;
import com.csci334.RCMS.repository.PaperRepository;
import com.csci334.RCMS.repository.ReviewerRepository;
import com.csci334.RCMS.repository.SystemAdminRepository;
import com.csci334.RCMS.service.AuthorService;
import com.csci334.RCMS.service.ConferenceService;
import com.csci334.RCMS.service.PaperService;
import com.csci334.RCMS.service.ReviewerService;
import com.csci334.RCMS.service.SystemAdminService;

import net.datafaker.Faker;

@Configuration
class LoadDatabase {
    
    @Autowired
	AuthorService aService;

    @Autowired
    PaperService pService;

    @Autowired
    ConferenceService cService;

    @Autowired
    ReviewerService rService;

    @Autowired
    SystemAdminService saService;

    @Bean
    CommandLineRunner initDatabase(AuthorRepository aRepository, ConferenceRepository cRepository, PaperRepository pRepository, ReviewerRepository rRepository, SystemAdminRepository sRepository, RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        Logger log = LoggerFactory.getLogger(LoadDatabase.class);
        Random random = new Random();
        Faker faker = new Faker();
        
        return args -> {
             String fullName;
             String lorem;
             String username;
             String password;

             // aService.createAuthor(new Author("Andreas", "ast", "123"));
             // pService.createPaper(new Paper(5, "Poggers", true, "p", "p"));
             // aService.addAuthorPaper(1L,1L);

             for (int i = 0; i < 100; i++) {
                 fullName = faker.name().fullName();
                 username = faker.name().username();
                 password = faker.internet().password();
                 aService.createAuthor(new Author(fullName, username, password));
             }

             for (int i = 0; i < 100; i++) {
                 lorem = faker.lorem().sentence(1, 5);
                 username = faker.name().username();
                 password = faker.internet().password();
                 pService.createPaper(new Paper(random.nextInt(0, 5), lorem, random.nextBoolean(), username, password));
             }

             for (int i = 0; i < 100; i++) {
                 fullName = faker.name().fullName();
                 username = faker.name().username();
                 password = faker.internet().password();
                 cService.createConference(new Conference(fullName, username, password));
             }

             for (int i = 0; i < 100; i++) {
                 fullName = faker.name().fullName();
                 username = faker.name().username();
                 password = faker.internet().password();
                 rService.createReviewer(new Reviewer(fullName, username, password));
             }

             for (int i = 0; i < 100; i++) {
                 fullName = faker.name().fullName();
                 username = faker.name().username();
                 password = faker.internet().password();
                 saService.createSystemAdmin(new SystemAdmin(fullName, username, password));
             }

             List<Long> paperIds = pService.getPaperIds();
             for (int i = 1; i < paperIds.size() + 1; i++) {
                 Integer randMax;
                 List<Long> authorIds = aService.getAuthorIds();
                 randMax = authorIds.size();
                 Long randAuthor;
                 if (randMax > 0) {
                     randAuthor = authorIds.get(random.nextInt(randMax));
                 } else {
                     randAuthor = authorIds.get(randMax);
                 }

                 List<Long> reviewerIds = rService.getReviewerIds();
                 randMax = reviewerIds.size();
                 Long randReviewer;
                 if (randMax > 0) {
                     randReviewer = reviewerIds.get(random.nextInt(randMax));
                 } else {
                     randReviewer = reviewerIds.get(randMax);
                 }
                 pService.addPaperAuthor(Long.valueOf(i), randAuthor);
                 pService.addPaperReviewer(Long.valueOf(i), randReviewer);
                 aService.addAuthorPaper(randAuthor, Long.valueOf(i));
                 rService.addReviewerPaper(randReviewer, Long.valueOf(i));
             }
        };
    }
}