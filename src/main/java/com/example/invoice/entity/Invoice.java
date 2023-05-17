package com.example.invoice.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate invoiceCreationDate;
    private LocalDate invoiceDeadline;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice(LocalDate invoiceCreationDate, LocalDate invoiceDeadline, Payment payment, Client client, Product product) {
        this.invoiceCreationDate = invoiceCreationDate;
        this.invoiceDeadline = invoiceDeadline;
        this.payment = payment;
        this.client = client;
        this.product = product;
    }

    public Invoice(LocalDate invoiceCreationDate, LocalDate invoiceDeadline, Payment payment, Client client) {
        this.invoiceCreationDate = invoiceCreationDate;
        this.invoiceDeadline = invoiceDeadline;
        this.payment = payment;
        this.client = client;
    }

    public LocalDate getInvoiceCreationDate() {
        return invoiceCreationDate;
    }

    public void setInvoiceCreationDate(LocalDate invoiceCreationDate) {
        this.invoiceCreationDate = invoiceCreationDate;
    }

    public LocalDate getInvoiceDeadline() {
        return invoiceDeadline;
    }

    public void setInvoiceDeadline(LocalDate invoiceDeadline) {
        this.invoiceDeadline = invoiceDeadline;
    }

    public Invoice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
