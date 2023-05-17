package com.example.invoice.controller;

import com.example.invoice.entity.Client;
import com.example.invoice.entity.Invoice;
import com.example.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoices")
    public String displayInvoicePage(Model model) {
        List<Invoice> invoiceList = invoiceService.findAllInvoicies();
        model.addAttribute("invoices", invoiceList);
        return "invoices";
    }
}
