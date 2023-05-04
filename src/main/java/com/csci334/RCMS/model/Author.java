package com.csci334.RCMS.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String username;

    private String password;

    private List<Long> paperIds;

    public Author() {}

    public Author(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        paperIds = new ArrayList<>();
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

    public void addPaperId(Long newPaperId) {
        paperIds.add(newPaperId);
    }

    public void setAuthor(Author author) {
        setId(author.id);
        setName(author.name);
        setUsername(author.username);
        setPassword(author.password);
    }

    public boolean equals(Author author) {
        if (this == author)
            return true;
        return Objects.equals(this.id, author.id) 
        && Objects.equals(this.name, author.name)
        && Objects.equals(this.username, author.username)
        && Objects.equals(this.password, author.password)
        && Objects.equals(this.paperIds, author.paperIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.username, this.password, this.paperIds);
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + this.id + "\'"
        + ", name='" + this.name + "\'"
        + ", username='" + this.username + "\'"
        + ", password='" + this.password + "\'"
        + ", paperIds='" + this.paperIds + "\'"
        + "}";
    }
}
