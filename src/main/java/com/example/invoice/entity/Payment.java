package com.example.invoice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String typeOfPayment;

    public Payment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    public Payment(String typeOfPayment, Invoice invoice) {
        this.typeOfPayment = typeOfPayment;
    }

    public Payment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }
}
