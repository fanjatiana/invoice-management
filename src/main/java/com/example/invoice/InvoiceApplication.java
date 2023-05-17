package com.example.invoice;

import com.example.invoice.service.ClientService;
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

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userService.addUser();
		clientService.addClient();


	}
}
