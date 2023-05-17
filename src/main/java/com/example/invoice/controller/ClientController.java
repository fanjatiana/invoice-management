package com.example.invoice.controller;

import com.example.invoice.entity.Address;
import com.example.invoice.entity.Client;
import com.example.invoice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/auth/clients")
    public String displayHomePage(Model model) {
        List<Client> clientList = clientService.findAllClients();
        model.addAttribute("clients", clientList);
        return "auth/clients";
    }

    @GetMapping("/auth/add-client")
    public String displayClientForm() {
        return "auth/add-client";
    }

    @PostMapping("/auth/add-client")
    public String handleClientForm(@RequestParam String firstname,
                                    @RequestParam String lastname,
                                    @RequestParam String phoneNumber,
                                    @RequestParam String address,
                                    @RequestParam String city,
                                    @RequestParam String zipCode,
                                    @RequestParam String compagnyName) {
        clientService.addClientByForm(firstname,lastname,phoneNumber,compagnyName,new Address(address,city,zipCode));
        return "redirect:/auth/clients";
    }
}
