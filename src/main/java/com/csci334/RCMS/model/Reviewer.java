package com.csci334.RCMS.model;

import java.util.List;

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
    private List<Long> paperIds;

    public Reviewer() {}

    public Reviewer(long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Long> getPaperIds() {
        return paperIds;
    }

    public void addPaperId(Long paperId) {
        paperIds.add(paperId);
    }

    public void setReviewer(Reviewer reviewer) {
        setId(reviewer.id);
        setName(reviewer.name);
    }
}
