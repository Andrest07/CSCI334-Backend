package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Reviewer;
import com.csci334.RCMS.repository.ReviewerRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewerService {
    private final ReviewerRepository reviewerRepository;

    public ReviewerService(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    public Reviewer getReviewerById(Long id) throws Exception{
        return reviewerRepository.findById(id).orElseThrow();
    }

    public Reviewer createReviewer(Reviewer newReviewer) {
        return reviewerRepository.save(newReviewer);
    }

    public Reviewer updateReviewer(Reviewer reviewer, Long id) throws Exception {
        Reviewer foundReviewer = getReviewerById(id);
        if (foundReviewer == null) {
            throw new Exception("Reviewer invalid");
        }
        foundReviewer.setReviewer(reviewer);
        return reviewerRepository.save(foundReviewer);
    }

    public void deleteReviewer(Long id) {
        reviewerRepository.deleteById(id);
    }
}
