package com.example.invoice;

import com.example.invoice.service.ClientService;
import com.example.invoice.service.InvoiceService;
import com.example.invoice.service.ProductService;
import com.example.invoice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvoiceApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	ClientService clientService;
	@Autowired
	ProductService productService;
	@Autowired
	InvoiceService invoiceService;


	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.addUser();
		invoiceService.addInvoice();

	}
}
