package com.example.coffeeshop.Services;

import java.util.List;


import com.example.coffeeshop.model.Osasto;
import com.example.coffeeshop.repos.OsastoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OsastoService {
    
    @Autowired
    private OsastoRepository osastoRepository;


    public List<Osasto> getAllOsastot() {
        return osastoRepository.findAll();
    }
}
