package com.example.invoice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String compagnyName;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    public Client() {
    }



    public Client(String firstname, String lastname, String phoneNumber, String compagnyName, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.compagnyName = compagnyName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompagnyName() {
        return compagnyName;
    }

    public void setCompagnyName(String compagnyName) {
        this.compagnyName = compagnyName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
