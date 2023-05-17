package com.example.invoice.service;

import com.example.invoice.entity.Address;
import com.example.invoice.entity.Client;
import com.example.invoice.entity.Role;
import com.example.invoice.entity.User;
import com.example.invoice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> addClient() {
        List<Client> clients = new ArrayList<>();
        Client client1 = clientRepository.save(new Client("Marc","Dupuit","0212254689","JoahVap",new Address("3 rue des marais","44600","Saint-Nazaire")));
        clients.add(client1);
        return clients;
    }

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }

}
