package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Reviewer;
import com.csci334.RCMS.repository.ReviewerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReviewerService {
    private final ReviewerRepository reviewerRepository;

    Logger log = LoggerFactory.getLogger(AuthorService.class);

    public ReviewerService(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    public Reviewer getReviewerById(Long id) throws Exception{
        return reviewerRepository.findById(id).orElseThrow();
    }

    public Reviewer createReviewer(Reviewer newReviewer) {
        log.info("Creating Reviewer: " + newReviewer);
        return reviewerRepository.save(newReviewer);
    }

    public Reviewer updateReviewer(Reviewer reviewer, Long id) throws Exception {
        Reviewer foundReviewer = getReviewerById(id);
        if (foundReviewer == null) {
            throw new Exception("Reviewer invalid");
        }
        foundReviewer.setReviewer(reviewer);
        log.info("Updating Reviewer: " + foundReviewer);
        return reviewerRepository.save(foundReviewer);
    }

    public void deleteReviewer(Long id) throws Exception {
        log.info("Deleting Reviewer: " + getReviewerById(id));
        reviewerRepository.deleteById(id);
    }

    public Reviewer addReviewerPaper(Long rId, Long pId) throws Exception {
        Reviewer r = getReviewerById(rId);
        r.addPaperId(pId);
        log.info("Adding Paper to Reviewer: " + r);
        return reviewerRepository.save(r);
    }
}
