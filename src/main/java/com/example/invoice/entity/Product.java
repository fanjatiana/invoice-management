package com.example.invoice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;

    private  String productDescription;

    private double priceHT;

   /* @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;*/


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "productCategory_id")
    private ProductCategory productCategory;
    public Product(String productName, String productDescription, double priceHT, ProductCategory productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.priceHT = priceHT;
        this.productCategory = productCategory;
    }
    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(float priceHT) {
        this.priceHT = priceHT;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setPriceHT(double priceHT) {
        this.priceHT = priceHT;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
