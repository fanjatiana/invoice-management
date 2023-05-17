package com.example.invoice.controller;

import com.example.invoice.entity.*;
import com.example.invoice.service.ClientService;
import com.example.invoice.service.InvoiceService;
import com.example.invoice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

    @GetMapping("/auth/invoices")
    public String displayInvoicePage(Model model) {
        List<Invoice> invoiceList = invoiceService.findAllInvoicies();
        model.addAttribute("invoices", invoiceList);
        return "auth/invoices";
    }

    @GetMapping("/auth/add-invoice")
    public String displayInvoiceForm(Model model) {
        List<Invoice> invoiceList = invoiceService.findAllInvoicies();
        model.addAttribute("invoices", invoiceList);

        List<Client> clientList = clientService.findAllClients();
        model.addAttribute("clients", clientList);

        List<Product> productList = productService.findAllProducts();
        model.addAttribute("products", productList);

        return "auth/add-invoice";
    }

    @PostMapping("/auth/add-invoice")
    public String handleProductForm(@RequestParam String invoiceCreationDate,
                                    @RequestParam String typeOfPayment,
                                    @RequestParam String compagnyName,
                                    @RequestParam String productName) {

        Client client = new Client(compagnyName);
        Product product = new Product(productName);
        Payment payment = new Payment(typeOfPayment);
        invoiceService.addInvoiceByForm(invoiceCreationDate, payment, client, product);
        return "redirect:/auth/invoices";
    }
}
