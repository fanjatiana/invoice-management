package com.example.invoice.service;
import com.example.invoice.entity.*;
import com.example.invoice.repository.ClientRepository;
import com.example.invoice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Client> addClientWithProduct() {
        List<Client> clients = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product("Jambon 4 tranches", "paquet de 4 tranches de jambon de la marque fleury michon", 6.18, new ProductCategory("Alimentaire"));
        Product product2 = new Product("Jambon 4 tranches", "paquet de 4 tranches de jambon de la marque fleury michon", 6.18, new ProductCategory("Alimentaire"));

        productRepository.save(product1);
        productRepository.save(product2);

        productList.add(product1);
        productList.add(product2);

        Client client1 = new Client("Marc", "Dupuit", "0212254689", "JoahVap", new Address("3 rue des marais", "44600", "Saint-Nazaire"), productList);
        clientRepository.save(client1);

        clients.add(client1);

        return clients;
    }

    public Client addClientByForm(String firstname, String lastname, String phoneNumber, String compagnyName, Address address) {
        Client newClient = new Client(firstname, lastname, phoneNumber, compagnyName, new Address(address.getStreetName(), address.getCity(), address.getZipCode()));
        clientRepository.save(newClient);
        return newClient;
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
}
