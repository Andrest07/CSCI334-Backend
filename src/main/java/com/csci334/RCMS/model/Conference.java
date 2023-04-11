package com.csci334.RCMS.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Conference")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String chairNumber;

    public Conference() {}

    public Conference(long id, String name, String chairNumber) {
        this.id = id;
        this.name = name;
        this.chairNumber = chairNumber;
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

    public void setConference(Conference conference) {
        setId(conference.id);
        setName(conference.name);
        setChairNumber(conference.chairNumber);
    }
}
