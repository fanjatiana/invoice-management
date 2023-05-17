package com.example.invoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/auth/home")
    public String displayHomePage() {
        return "auth/home";
    }

}
