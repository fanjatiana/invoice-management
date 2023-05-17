package com.example.invoice.controller;

import com.example.invoice.entity.User;
import com.example.invoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth/profile")
    public String showProfile(Model model, Authentication authentication) {

        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            Optional<User> optionalUser = userRepository.findByEmail(email);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                model.addAttribute("user", user);
                return "auth/profile";
            } else {
                return "404";
            }
        }
        return "redirect:/login";
    }
}
