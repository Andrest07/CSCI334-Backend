package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Reviewer;
import com.csci334.RCMS.repository.ReviewerRepository;

import java.util.ArrayList;
import java.util.List;

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

    public List<Reviewer> getReviewers() {
		return reviewerRepository.findAll();
	}

	public List<Long> getReviewerIds() {
		List<Long> ids = new ArrayList<Long>();
		List<Reviewer> reviewers = getReviewers();
		for(int i=0;i<reviewers.size();i++) {
			ids.add(reviewers.get(i).getId());
		}
		return ids;
	}

    public Reviewer getReviewerById(Long id) throws Exception{
        return reviewerRepository.findById(id).orElseThrow();
    }

    public Reviewer createReviewer(Reviewer newReviewer) {
        try {
            return reviewerRepository.save(newReviewer);
        } finally {
            log.info("Creating Reviewer: " + newReviewer);
        }
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
