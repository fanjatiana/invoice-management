package com.example.invoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @PostMapping("/auth/logout")
    public String displayLoginForm() {
        return "login";
    }
}
