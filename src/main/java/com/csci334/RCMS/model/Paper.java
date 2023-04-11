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
    @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Author> author = new ArrayList<>();

    @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reviewer> reviewer = new ArrayList<>();
    public Paper() {}

    public Paper(long id, int rating, String comment, boolean accepted, List<Author> author, List<Reviewer> reviewer) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.accepted = accepted;
        this.author = author;
        this.reviewer = reviewer;
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

    public List<Author> getAuthor(){ return author; }

    public void setAuthor(List<Author> author) { this.author = author; }

    public List<Reviewer> getReviewer() {
        return reviewer;
    }

    public void setReviewer(List<Reviewer> reviewer) {
        this.reviewer = reviewer;
    }

    public void setPaper(Paper paper){
        setId(paper.id);
        setRating(paper.rating);
        setComment(paper.comment);
        setAccepted(paper.accepted);
        setAuthor(paper.author);
    }
}
