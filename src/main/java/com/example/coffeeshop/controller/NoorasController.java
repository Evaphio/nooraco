package com.example.coffeeshop.controller;

import java.io.IOException;
import java.math.BigDecimal;

import com.example.coffeeshop.Services.OsastoService;
import com.example.coffeeshop.Services.ToimittajaService;
import com.example.coffeeshop.Services.TuotteenHallintaService;
import com.example.coffeeshop.Services.ValmistajaService;
import com.example.coffeeshop.model.Osasto;
import com.example.coffeeshop.model.Toimittaja;
import com.example.coffeeshop.model.Valmistaja;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NoorasController {

    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;

    @Autowired
    private ValmistajaService valmistajaService;

    @Autowired
    private ToimittajaService toimittajaService;

    @Autowired
    private OsastoService osastoService;

    // Retrieves information from the base for adding a product
    @GetMapping("/manage-goods")
    public String editProduct(Model model) {
        model.addAttribute("tuotteet", tuotteenHallintaService.getAllProducts());
        model.addAttribute("osastot", osastoService.getAllOsastot());
        model.addAttribute("toimittajat", toimittajaService.getAllToimittajat());
        model.addAttribute("valmistajat", valmistajaService.getAllValmistajat());
        return "manage-goods";
    }    

    // Add a new product to the database

    @PostMapping("/manage-goods")
    public String lisaaTuote(@RequestParam String nimi, @RequestParam String kuvaus, @RequestParam BigDecimal hinta, @RequestParam("tuotekuva") MultipartFile tuotekuva, @RequestParam Toimittaja toimittaja, @RequestParam Valmistaja valmistaja, @RequestParam Osasto osasto) throws IOException {
        tuotteenHallintaService.addTuote(nimi, kuvaus, hinta, tuotekuva, toimittaja, valmistaja, osasto);
        return "redirect:/manage-goods";
    }

 
}
