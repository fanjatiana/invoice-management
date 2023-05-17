package com.example.invoice.service;

import com.example.invoice.entity.*;
import com.example.invoice.repository.ClientRepository;
import com.example.invoice.repository.InvoiceRepository;
import com.example.invoice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {


    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Invoice> addInvoice() {
        Client client1 = clientRepository.save(new Client("Marc", "Dupuit", "0212254689", "JoahVap", new Address("3 rue des marais", "44600", "Saint-Nazaire")));

        LocalDate today = LocalDate.now();
        LocalDate invoiceDeadline = today.plusMonths(1);

        Product product1 = new Product("Jambon 4 tranches", "paquet de 4 tranches de jambon de la marque fleury michon", 6.18, new ProductCategory("Alimentaire"));

        List<Invoice> invoices = new ArrayList<>();
        Invoice invoice1 = new Invoice(today, invoiceDeadline, new Payment("Chèque"), client1,product1);


       invoiceRepository.save(invoice1); // Enregistrer l'invoice

       productRepository.save(product1); // Enregistrer le produit

        return invoices;
    }

  /* public Product addProductByForm(String productName, String productDescription, String priceHt, ProductCategory productCategory) {
        double price= Double.parseDouble(priceHt);
        Product newProduct = new Product(productName, productDescription, price, new ProductCategory(productCategory.getCategoryName()));
        productRepository.save(newProduct);
        return newProduct;
    }*/

    public List<Invoice> findAllInvoicies() {
        return invoiceRepository.findAll();
    }
}
