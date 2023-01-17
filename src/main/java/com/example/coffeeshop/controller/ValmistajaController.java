package com.example.coffeeshop.controller;

import com.example.coffeeshop.Services.ValmistajaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValmistajaController {

    @Autowired
    private ValmistajaService valmistajaService;

    // List all manufacturers
    @GetMapping("/manage-manufacturer")
    public String listValmistajat(Model model) {
        model.addAttribute("valmistajat", valmistajaService.getAllValmistajat());
        return "manage-manufacturer";
    }

    // Add to the manufacturer's database

    @PostMapping("/manage-manufacturer")
    public String addValmistaja(@RequestParam String nimi, @RequestParam String url) {
        valmistajaService.addValmistaja(nimi, url);
        return "redirect:/manage-manufacturer";
    }

    // Shows one manufacturer's information on the main page, redirects to the manufacturer's page
    @GetMapping("/manage-manufacturer/{id}")
    public String showValmistaja(@RequestParam Long id, Model model) {
        valmistajaService.findValmistaja(id);
        return "redirect:/valmistaja/" + id;
    }

    // Based on the id, displays the information of one manufacturer on the manufacturer page 
    @GetMapping("/valmistaja/{id}")
    public String showOneValmistaja(@PathVariable Long id, Model model) {
        model.addAttribute("valmistaja", valmistajaService.findValmistaja(id));
        return "valmistaja";
    }


}    
