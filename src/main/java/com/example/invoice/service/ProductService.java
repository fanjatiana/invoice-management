package com.example.invoice.service;

import com.example.invoice.entity.Address;
import com.example.invoice.entity.Client;
import com.example.invoice.entity.Product;
import com.example.invoice.entity.ProductCategory;
import com.example.invoice.repository.ClientRepository;
import com.example.invoice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> addProduct() {
        List<Product> products = new ArrayList<>();
        Product product1 = productRepository.save(new Product("Jambon 4 tranches", "paquet de 4 tranches de jambon de la marque fleury michon", 6.18, new ProductCategory("Alimentaire")));
        products.add(product1);
        return products;
    }

    public Product addProductByForm(String productName, String productDescription, String priceHt, ProductCategory productCategory) {
        double price= Double.parseDouble(priceHt);
        Product newProduct = new Product(productName, productDescription, price, new ProductCategory(productCategory.getCategoryName()));
        productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
