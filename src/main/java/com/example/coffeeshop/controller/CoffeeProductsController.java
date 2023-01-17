package com.example.coffeeshop.controller;

import java.util.List;
import com.example.coffeeshop.Services.TuotteenHallintaService;
import com.example.coffeeshop.model.Tuote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoffeeProductsController {

    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;

    // show products (all or based on search)
    @GetMapping(path= {"/products", "/searchProducts"})
    public String products(Model model, @Param ("hakusana") String hakusana) {
        List<Tuote> listProducts = tuotteenHallintaService.listAllproductsHakusanalla(hakusana);
        model.addAttribute("products", listProducts);
        return "products";
    }

    // Retrieves the image of the product and displays it on the consumer product page
    @ResponseBody
    @GetMapping("/kulutustuote/tuoteKuva/{id}")
    public byte[] getImage(@PathVariable Long id) {
        return tuotteenHallintaService.getTuoteImage(id);
    }

}
