package com.csci334.RCMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csci334.RCMS.model.Review;
import com.csci334.RCMS.service.ReviewService;

@RestController
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
	List<Review> all() {
		return reviewService.getReviews();
	}

	@GetMapping("/reviews/ids")
	List<Long> getReviewIds(){
		return reviewService.getReviewIds();
	}

    @GetMapping("/review/{id}")
    Review getReviewById(@PathVariable Long id) throws Exception {
        return reviewService.getReviewById(id);
    }

    @PostMapping("/createReview")
    Review createReview(@RequestBody Review newReview) {
        return reviewService.createReview(newReview);
    }

    @PutMapping("/updateReview/{id}")
    Review updateReview(@RequestBody Review review, @PathVariable Long id) throws Exception {
        return reviewService.updateReview(review, id);
    }

    @DeleteMapping({"/deleteReview/{id}"})
    void deleteReview(@PathVariable Long id) throws Exception {
        reviewService.deleteReview(id);
    }

    @PutMapping("/addReviewPaper/{rId}/{pId}")
	Review putReviewPaper(@PathVariable Long rId, @PathVariable Long pId) throws Exception {
		return reviewService.addReviewPaper(rId, pId);
	}

    @PutMapping("/addReviewReviewer/{rId}/{rrId}")
	Review putProfessionalRating(@PathVariable Long rId, @PathVariable Long rrId) throws Exception {
		return reviewService.addReviewReviewer(rId, rrId);
	}
}
