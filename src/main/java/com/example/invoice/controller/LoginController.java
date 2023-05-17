package com.example.invoice.controller;

import com.example.invoice.entity.User;
import com.example.invoice.repository.UserRepository;
import com.example.invoice.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String displayLoginForm() {

        return "login";
    }

    @PostMapping("/login")
    public String handleLoginForm(@RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  HttpSession session, Model model) {
        Optional<User> optionalUser = userService.findUserByEmailAndPassword(email, password);
        if (optionalUser.isPresent()) {
            session.setAttribute("user", optionalUser);
            return "redirect:/auth/home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}
