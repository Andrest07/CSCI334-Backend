package com.csci334.RCMS.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Reviewer")
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "paper_id")
    private Paper paper;

    public Reviewer() {}

    public Reviewer(long id, String name, Paper paper) {
        this.id = id;
        this.name = name;
        this.paper = paper;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public void setReviewer(Reviewer reviewer) {
        setId(reviewer.id);
        setName(reviewer.name);
    }
}
