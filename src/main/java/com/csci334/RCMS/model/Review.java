package com.csci334.RCMS.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int rating;

    private String comment;

    //@JsonIgnoreProperties("paper")
    private List<Long> paperIds;

    private List<Long> reviewerIds;
    public Review() {}

    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
        this.paperIds = new ArrayList<>();
        this.reviewerIds = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Long> getPaperIds(){ 
        return paperIds; 
    }

    public void addPaperId(Long paperId) { 
        paperIds.add(paperId); 
    }

    public List<Long> getReviewerIds() {
        return reviewerIds;
    }

    public void addReviewerId(Long reviewerId) {
        reviewerIds.add(reviewerId);
    }

    public void setReview(Review review){
        setId(review.id);
        setRating(review.rating);
        setComment(review.comment);
    }

    public boolean equals(Review review) {
        if (this == review)
            return true;
        return Objects.equals(this.id, review.id) 
        && Objects.equals(this.rating, review.rating)
        && Objects.equals(this.comment, review.comment)
        && Objects.equals(this.paperIds, review.paperIds)
        && Objects.equals(this.reviewerIds, review.reviewerIds)
        ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.rating, this.comment,this.paperIds, this.reviewerIds);
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + this.id + "\'"
        + ", rating='" + this.rating + "\'"
        + ", comment='" + this.comment + "\'"
        + ", paperIds='" + this.paperIds + "\'"
        + ", reviewerIds='" + this.reviewerIds + "\'"
        + "}";
    }
}