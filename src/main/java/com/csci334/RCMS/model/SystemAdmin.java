package com.csci334.RCMS.model;

import jakarta.persistence.*;

@Entity
@Table(name = "System Admin")
public class SystemAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public SystemAdmin() {}

    public SystemAdmin(long id, String name) {
        this.id = id;
        this.name = name;
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
}
