package com.csci334.RCMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int rating;

    private String comment;

    private boolean accepted;

    private String username;

    private String password;

    //@JsonIgnoreProperties("paper")
    private List<Long> authorIds;

    private List<Long> reviewerIds;
    public Paper() {}

    public Paper(int rating, String comment, boolean accepted, String username, String password) {
        this.rating = rating;
        this.comment = comment;
        this.accepted = accepted;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean equals(Paper paper) {
        if (this == paper)
            return true;
        return Objects.equals(this.id, paper.id) 
        && Objects.equals(this.rating, paper.rating)
        && Objects.equals(this.comment, paper.comment)
        && Objects.equals(this.accepted, paper.accepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.rating, this.comment, this.accepted);
    }

    @Override
    public String toString() {
        return "Paper{" + "id=" + this.id + "\'"
        + ", rating='" + this.rating + "\'"
        + ", comment='" + this.comment + "\'"
        + ", accepted='" + this.accepted + "\'"
        + "}";
    }
}
