package com.csci334.RCMS.controller;

import com.csci334.RCMS.model.Reviewer;
import com.csci334.RCMS.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewerController {
    @Autowired
    private final ReviewerService reviewerService;

    public ReviewerController(ReviewerService reviewerService) {
        this.reviewerService = reviewerService;
    }

    @GetMapping("/reviewer/{id}")
    Reviewer getReviewerById(@PathVariable Long id) throws Exception {
        return reviewerService.getReviewerById(id);
    }

    @PostMapping("/createReviewer")
    Reviewer createReviewer(@RequestBody Reviewer newReviewer) {
        return reviewerService.createReviewer(newReviewer);
    }

    @PutMapping("/updateReviewer/{id}")
    Reviewer updateReviewer(@RequestBody Reviewer reviewer, @PathVariable Long id) throws Exception {
        return reviewerService.updateReviewer(reviewer, id);
    }

    @DeleteMapping({"/deleteReviewer/{id}"})
    void deleteReviewer(@PathVariable Long id) {
        reviewerService.deleteReviewer(id);
    }
}
