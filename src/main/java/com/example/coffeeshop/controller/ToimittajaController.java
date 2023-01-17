package com.example.coffeeshop.controller;

import com.example.coffeeshop.Services.ToimittajaService;
import com.example.coffeeshop.model.Toimittaja;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToimittajaController {

    @Autowired
    private ToimittajaService toimittajaService;

   

 //get type request lists all suppliers in the database (listens for requests to manage-delivery)
    @GetMapping("/manage-delivery")
    public String listToimittajat(Model model) {
        model.addAttribute("toimittajat", toimittajaService.getAllToimittajat());
        return "manage-delivery";
    }

//a post type request to the path /manage-delivery adds the supplier to the database

    @PostMapping("/manage-delivery")
    public String addToimittaja(@ModelAttribute Toimittaja toimittaja){
         toimittajaService.addToimittaja(toimittaja);
         return "redirect:/manage-delivery";

     }

// listens for requests to /manage-delivery followed by a path variable specifying the vendor ID
    @GetMapping("/manage-delivery/{id}")
    public String showToimittaja(@RequestParam Long id, Model model) {
        toimittajaService.findToimittaja(id);
        return "redirect:/toimittaja/" + id;
    }

 //a get type request to the path /supplier/{id} retrieves and displays the information of a specific supplier
    @GetMapping("/toimittaja/{id}")
    public String showOneToimittaja(@PathVariable Long id, Model model) {
        model.addAttribute("toimittaja", toimittajaService.findToimittaja(id));
        return "toimittaja";
    }


}


