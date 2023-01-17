package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeShopController {
    
    @GetMapping
    public String home() {
        return "index";
    }
    
}

    






