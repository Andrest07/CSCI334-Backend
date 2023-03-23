package com.csci334.RCMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnoreProperties("author")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Paper_id")
    private Paper paper;
    public Author() {}

    public Author(long id, Paper paper) {
        this.id = id;
        this.paper = paper;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        setId(author.id);
    }
}
