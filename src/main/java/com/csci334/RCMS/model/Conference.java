package com.csci334.RCMS.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "Conference")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String chairNumber;

    private String username;

    private String password;

    public Conference() {}

    public Conference(String name, String chairNumber, String username, String password) {
        this.name = name;
        this.chairNumber = chairNumber;
        this.username = username;
        this.password = password;
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

    public String getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(String chairNumber) {
        this.chairNumber = chairNumber;
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

    public void setConference(Conference conference) {
        setId(conference.id);
        setName(conference.name);
        setChairNumber(conference.chairNumber);
    }

    public boolean equals(Conference conference) {
        if (this == conference)
            return true;
        return Objects.equals(this.id, conference.id) 
        && Objects.equals(this.name, conference.name)
        && Objects.equals(this.chairNumber, conference.chairNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.chairNumber);
    }

    @Override
    public String toString() {
        return "Conference{" + "id=" + this.id + "\'"
        + ", name='" + this.name + "\'"
        + ", chairNumber='" + this.chairNumber + "\'"
        + "}";
    }
}
