package com.csci334.RCMS.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csci334.RCMS.model.Review;
import com.csci334.RCMS.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    Logger log = LoggerFactory.getLogger(ReviewService.class);

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
		return reviewRepository.findAll();
	}

	public List<Long> getReviewIds() {
		List<Long> ids = new ArrayList<Long>();
		List<Review> reviews = getReviews();
		for(int i=0;i<reviews.size();i++) {
			ids.add(reviews.get(i).getId());
		}
		return ids;
	}

    public Review getReviewById(Long id) throws Exception{
        return reviewRepository.findById(id).orElseThrow();
    }

    public Review createReview(Review newReview) {
        try {
            return reviewRepository.save(newReview);
        } finally {
            log.info("Creating Review:" + newReview);
        }
    }

    public Review updateReview(Review review, Long id) throws Exception {
        Review foundReview = getReviewById(id);
        if (foundReview == null) {
            throw new Exception("Review invalid");
        }
        foundReview.setReview(review);
        log.info("Updating Paper:" + foundReview);
        return reviewRepository.save(foundReview);
    }

    public void deleteReview(Long id) throws Exception {
        log.info("Deleting Review:" + getReviewById(id));
        reviewRepository.deleteById(id);
    }

    public Review addReviewPaper(Long rId, Long pId) throws Exception {
        Review r = getReviewById(rId);
        r.addPaperId(pId);
        log.info("Adding Paper to Review: " + r);
        return reviewRepository.save(r);
    }

    public Review addReviewReviewer(Long rId, Long rrId) throws Exception {
        Review r = getReviewById(rId);
        r.addReviewerId(rrId);
        log.info("Adding Reviewer to Review: " + r);
        return reviewRepository.save(r);
    }
}
