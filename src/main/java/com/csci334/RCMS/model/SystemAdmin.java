package com.csci334.RCMS.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "System Admin")
public class SystemAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        setId(systemAdmin.id);
        setName(systemAdmin.name);
    }

    public boolean equals(SystemAdmin systemAdmin) {
        if (this == systemAdmin)
            return true;
        return Objects.equals(this.id, systemAdmin.id) 
        && Objects.equals(this.name, systemAdmin.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "SystemAdmin{" + "id=" + this.id + "\'"
        + ", name='" + this.name + "\'"
        + "}";
    }
}
