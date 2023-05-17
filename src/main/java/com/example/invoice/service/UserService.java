package com.example.invoice.service;

import com.example.invoice.entity.Role;
import com.example.invoice.entity.User;
import com.example.invoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> addUser() {
        List<User> users = new ArrayList<>();
        User userAdmin = userRepository.save(new User("Sophie", "Toto", "admin@my-invoice.fr", "qwerty", new Role("ADMIN")));
        users.add(userAdmin);
        return users;
    }

    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }
}
