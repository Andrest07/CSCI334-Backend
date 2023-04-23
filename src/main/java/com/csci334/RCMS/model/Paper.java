package com.csci334.RCMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int rating;
    private String comment;
    private boolean accepted;

    //@JsonIgnoreProperties("paper")
    private List<Long> authorIds;

    private List<Long> reviewerIds;
    public Paper() {}

    public Paper(long id, int rating, String comment, boolean accepted) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.accepted = accepted;
        this.authorIds = new ArrayList<>();
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

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public List<Long> getAuthorIds(){ return authorIds; }

    public void addAuthorId(Long authorId) { authorIds.add(authorId); }

    public List<Long> getReviewerIds() {
        return reviewerIds;
    }

    public void addReviewerId(Long reviewerId) {
        reviewerIds.add(reviewerId);
    }

    public void setPaper(Paper paper){
        setId(paper.id);
        setRating(paper.rating);
        setComment(paper.comment);
        setAccepted(paper.accepted);
    }
}
