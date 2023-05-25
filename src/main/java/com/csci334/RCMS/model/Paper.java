package com.csci334.RCMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int rating;

    private boolean accepted;

    private boolean liked;

    //@JsonIgnoreProperties("paper")
    private List<String> comments;

    private List<Long> authorIds;

    private List<Long> reviewerIds;
    public Paper() {}

    public Paper(int rating, boolean accepted, boolean liked) {
        this.rating = rating;
        this.accepted = accepted;
        this.liked = liked;
        this.comments = new ArrayList<>();
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

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public List<String> getComments(){ 
        return comments; 
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void addComment(String comment) {
        comments.add(comment); 
    }

    public List<Long> getAuthorIds(){ return authorIds; }

    public void addAuthorId(Long authorId) { authorIds.add(authorId); }

    public List<Long> getReviewerIds() {
        return reviewerIds;
    }

    public void addReviewerId(Long reviewerId) {
        reviewerIds.add(reviewerId);
    }

    public void setAuthorIds(List<Long> authorIds) {
        this.authorIds = authorIds;
    }

    public void setReviewerIds(List<Long> reviewerIds) {
        this.reviewerIds = reviewerIds;
    }

    public void setPaper(Paper paper){
        setId(paper.id);
        setRating(paper.rating);
        setAccepted(paper.accepted);
        setLiked(paper.liked);
        setComments(paper.comments);
        setAuthorIds(paper.authorIds);
    }

    public boolean equals(Paper paper) {
        if (this == paper)
            return true;
        return Objects.equals(this.id, paper.id) 
        && Objects.equals(this.rating, paper.rating)
        && Objects.equals(this.accepted, paper.accepted)
        && Objects.equals(this.liked, paper.liked)
        && Objects.equals(this.comments, paper.comments)
        && Objects.equals(this.authorIds, paper.authorIds)
        && Objects.equals(this.reviewerIds, paper.reviewerIds)
        ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.rating, this.accepted, this.liked, this.comments, this.authorIds, this.reviewerIds);
    }

    @Override
    public String toString() {
        return "Paper{" + "id=" + this.id + "\'"
        + ", rating='" + this.rating + "\'"
        + ", accepted='" + this.accepted + "\'"
        + ", liked='" + this.liked + "\'"
        + ", comments='" + this.comments + "\'"
        + ", authorIds='" + this.authorIds + "\'"
        + ", reviewerIds='" + this.reviewerIds + "\'"
        + "}";
    }
}
