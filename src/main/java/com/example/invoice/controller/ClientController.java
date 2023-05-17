package com.example.invoice.controller;

import com.example.invoice.entity.Address;
import com.example.invoice.entity.Client;
import com.example.invoice.repository.ClientRepository;
import com.example.invoice.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String displayHomePage(Model model) {
        List<Client> clientList = clientService.findAllClients();
        model.addAttribute("clients", clientList);
        return "clients";
    }

    @GetMapping("/add-client")
    public String displayClientForm() {
        return "add-client";
    }

    @PostMapping("/add-client")
    public String handleClientForm(@RequestParam String firstname,
                                    @RequestParam String lastname,
                                    @RequestParam String phoneNumber,
                                    @RequestParam String address,
                                    @RequestParam String city,
                                    @RequestParam String zipCode,
                                    @RequestParam String compagnyName) {
        clientService.addClientByForm(firstname,lastname,phoneNumber,compagnyName,new Address(address,city,zipCode));
        return "redirect:/clients";
    }
}
