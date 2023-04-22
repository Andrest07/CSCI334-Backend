package com.csci334.RCMS.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    //@JsonIgnoreProperties("author")
    @ManyToOne
    @JoinColumn(name = "paper_id")
    private List<Long> paperIds;

    public Author() {}

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
        this.paperIds = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setAuthor(Author author) {
        setId(author.id);
        setName(author.name);
    }
}
