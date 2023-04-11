package com.csci334.RCMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    //@JsonIgnoreProperties("author")
    @ManyToOne
    @JoinColumn(name = "paper_id")
    private Paper paper;

    public Author() {}

    public Author(long id, String name, Paper paper) {
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

    public void setAuthor(Author author) {
        setId(author.id);
        setName(author.name);
    }
}