package com.csci334.RCMS.model;

import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Conference")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen2")
    @GenericGenerator(
            name = "idGen2",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name2", value = "your_entity_sequence2"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    private String name;

    //private String chairNumber;

    private String username;

    private String password;

    public Conference() {}

    public Conference(String name, String username, String password) {
        this.name = name;
        //this.chairNumber = chairNumber;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
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

    // public String getChairNumber() {
    //     return chairNumber;
    // }

    // public void setChairNumber(String chairNumber) {
    //     this.chairNumber = chairNumber;
    // }

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
        // setChairNumber(conference.chairNumber);
        setUsername(conference.username);
        setPassword(conference.password);
    }

    public boolean equals(Conference conference) {
        if (this == conference)
            return true;
        return Objects.equals(this.id, conference.id) 
        && Objects.equals(this.name, conference.name)
        // && Objects.equals(this.chairNumber, conference.chairNumber)
        && Objects.equals(this.username, conference.username)
        && Objects.equals(this.password, conference.password)
        ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.username, this.password);
    }

    @Override
    public String toString() {
        return "Conference{" + "id=" + this.id + "\'"
        + ", name='" + this.name + "\'"
        //+ ", chairNumber='" + this.chairNumber + "\'"
        + ", username='" + this.username + "\'"
        + ", password='" + this.password + "\'"
        + "}";
    }
}
