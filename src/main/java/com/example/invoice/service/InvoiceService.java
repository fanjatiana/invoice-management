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
        Client client2 = clientRepository.save(new Client("Julie", "Chateau", "0212254689", "PetShop", new Address("30 rue des puits", "44000", "Nantes")));
        LocalDate today = LocalDate.now();
        LocalDate invoiceDeadline = today.plusMonths(1);

        Product product1 = new Product("Jambon 4 tranches", "paquet de 4 tranches de jambon de la marque fleury michon", 6.18, new ProductCategory("Alimentaire"));
        List<Invoice> invoices = new ArrayList<>();
        Invoice invoice1 = new Invoice(today, invoiceDeadline, new Payment("Chèque"), client1, product1);
        invoiceRepository.save(invoice1);
        productRepository.save(product1);


        Product productClient2_1 = new Product("manteau", "Manteau d'hiver noir", 98.98, new ProductCategory("Vêtement"));
        Product productClient2_2 = new Product("Deodorant", "Deodorant nartha", 58.98, new ProductCategory("Hygiène"));
        Invoice invoice2 = new Invoice(today, invoiceDeadline, new Payment("CB"), client2, productClient2_1);
        Invoice invoice3 = new Invoice(today, invoiceDeadline, new Payment("CB"), client2, productClient2_2);

        invoiceRepository.save(invoice2);
        invoiceRepository.save(invoice3);
        productRepository.save(productClient2_1);
        productRepository.save(productClient2_2);


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
