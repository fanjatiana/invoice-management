package com.example.invoice.controller;

import com.example.invoice.entity.Client;
import com.example.invoice.repository.ClientRepository;
import com.example.invoice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
