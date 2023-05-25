package com.csci334.RCMS.model;

import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "System Admin")
public class SystemAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen5")
    @GenericGenerator(
            name = "idGen5",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name5", value = "your_entity_sequence5"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    private String name;

    private String username;

    private String password;

    public SystemAdmin() {}

    public SystemAdmin(String name, String username, String password) {
        this.name = name;
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

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        setId(systemAdmin.id);
        setName(systemAdmin.name);
        setUsername(systemAdmin.username);
        setPassword(systemAdmin.password);
    }

    public boolean equals(SystemAdmin systemAdmin) {
        if (this == systemAdmin)
            return true;
        return Objects.equals(this.id, systemAdmin.id) 
        && Objects.equals(this.name, systemAdmin.name)
        && Objects.equals(this.username, systemAdmin.username)
        && Objects.equals(this.password, systemAdmin.password)
        ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.username, this.password);
    }

    @Override
    public String toString() {
        return "SystemAdmin{" + "id=" + this.id + "\'"
        + ", name='" + this.name + "\'"
        + ", username='" + this.username + "\'"
        + ", password='" + this.password + "\'"
        + "}";
    }
}
