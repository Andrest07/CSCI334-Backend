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
@Table(name = "Bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@JsonIgnoreProperties("paper")
    private List<Long> paperIds;

    private List<Long> reviewerIds;
    public Bid() {}

    public Bid(int rating, String comment) {
        this.paperIds = new ArrayList<>();
        this.reviewerIds = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setBid(Bid bid){
        setId(bid.id);
    }

    public boolean equals(Bid bid) {
        if (this == bid)
            return true;
        return Objects.equals(this.id, bid.id) 
        && Objects.equals(this.paperIds, bid.paperIds)
        && Objects.equals(this.reviewerIds, bid.reviewerIds)
        ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.paperIds, this.reviewerIds);
    }

    @Override
    public String toString() {
        return "Bid{" + "id=" + this.id + "\'"
        + ", paperIds='" + this.paperIds + "\'"
        + ", reviewerIds='" + this.reviewerIds + "\'"
        + "}";
    }
}
