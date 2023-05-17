package com.example.invoice.entity;

import jakarta.persistence.*;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roleName;

    public Role(String role) {
        this.roleName = role;
    }

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return roleName;
    }

    public void setRole(String role) {
        this.roleName = role;
    }
}
