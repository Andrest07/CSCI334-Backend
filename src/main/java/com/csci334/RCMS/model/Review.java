package com.csci334.RCMS.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen3")
    @GenericGenerator(
            name = "idGen3",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name3", value = "your_entity_sequence3"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    private int rating;

    private List<String> comments;

    //@JsonIgnoreProperties("paper")
    private List<Long> paperIds;

    private List<Long> reviewerIds;
    public Review() {}

    public Review(int rating) {
        this.rating = rating;
        this.comments = new ArrayList<>();
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

    public List<String> getComments(){ 
        return comments; 
    }

    public void addComment(String comment) { 
        comments.add(comment); 
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
    }

    public boolean equals(Review review) {
        if (this == review)
            return true;
        return Objects.equals(this.id, review.id) 
        && Objects.equals(this.rating, review.rating)
        && Objects.equals(this.comments, review.comments)
        && Objects.equals(this.paperIds, review.paperIds)
        && Objects.equals(this.reviewerIds, review.reviewerIds)
        ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.rating, this.comments,this.paperIds, this.reviewerIds);
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + this.id + "\'"
        + ", rating='" + this.rating + "\'"
        + ", comments='" + this.comments + "\'"
        + ", paperIds='" + this.paperIds + "\'"
        + ", reviewerIds='" + this.reviewerIds + "\'"
        + "}";
    }
}
