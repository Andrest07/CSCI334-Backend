package com.csci334.RCMS.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "Reviewer")
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String username;

    private String password;

    private List<Long> paperIds;

    public Reviewer() {}

    public Reviewer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        paperIds = new ArrayList<Long>();
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

    public boolean equals(Reviewer reviewer) {
        if (this == reviewer)
            return true;
        return Objects.equals(this.id, reviewer.id) 
        && Objects.equals(this.name, reviewer.name)
        && Objects.equals(this.paperIds, reviewer.paperIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.paperIds);
    }

    @Override
    public String toString() {
        return "Reviewer{" + "id=" + this.id + "\'"
        + ", name='" + this.name + "\'"
        + ", paperIds='" + this.paperIds + "\'"
        + "}";
    }
}
