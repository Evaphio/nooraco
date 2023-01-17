package com.example.coffeeshop.controller;

import java.util.List;
import com.example.coffeeshop.Services.TuotteenHallintaService;
import com.example.coffeeshop.model.Tuote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoffeeMachinesController {
    
    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;

    // show machines (all or based on search)
    @GetMapping(path= {"/machines", "/search"})
    public String machines(Model model, @Param("hakusana") String hakusana) {
        List<Tuote> listProducts = tuotteenHallintaService.listAllmachinesHakusanalla(hakusana);
        model.addAttribute("machines", listProducts);
        return "machines";
    }

    // get picture from database
    @ResponseBody
    @GetMapping("/kahvilaite/tuoteKuva/{id}")
    public byte[] getImage(@PathVariable Long id) {
        return tuotteenHallintaService.getTuoteImage(id);
    }

    
 
    @GetMapping("/manage")
    public String productMaintenance() {
        return "manage";
    }
}
