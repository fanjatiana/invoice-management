package com.example.invoice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productCategory")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoryName;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategory() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
