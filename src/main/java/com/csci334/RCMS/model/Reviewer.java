package com.csci334.RCMS.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Reviewer")
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen4")
    @GenericGenerator(
            name = "idGen4",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name4", value = "your_entity_sequence4"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    private String name;

    private String username;

    private String password;

    private Integer bids;

    private List<Long> paperIds;

    public Reviewer() {}

    public Reviewer(String name, String username, String password, Integer bids) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.bids = bids;
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

    public Integer getBids() {
        return bids;
    }

    public void setBids(Integer bids) {
        this.bids = bids;
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
        setUsername(reviewer.username);
        setPassword(reviewer.password);
        setBids(reviewer.bids);
    }

    public boolean equals(Reviewer reviewer) {
        if (this == reviewer)
            return true;
        return Objects.equals(this.id, reviewer.id) 
        && Objects.equals(this.name, reviewer.name)
        && Objects.equals(this.username, reviewer.username)
        && Objects.equals(this.password, reviewer.password)
        && Objects.equals(this.bids, reviewer.bids)
        && Objects.equals(this.paperIds, reviewer.paperIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.username, this.password, this.bids, this.paperIds);
    }

    @Override
    public String toString() {
        return "Reviewer{" + "id=" + this.id + "\'"
        + ", name='" + this.name + "\'"
        + ", username='" + this.username + "\'"
        + ", password='" + this.password + "\'"
        + ", bids='" + this.bids + "\'"
        + ", paperIds='" + this.paperIds + "\'"
        + "}";
    }
}
