package com.example.coffeeshop.Services;

import java.util.List;
import javax.transaction.Transactional;
import com.example.coffeeshop.model.Valmistaja;
import com.example.coffeeshop.repos.ValmistajaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValmistajaService {
    
    @Autowired
    private ValmistajaRepository valmistajaRepository;

    public List<Valmistaja> getAllValmistajat() {
        return valmistajaRepository.findAll();
    }

    public void addValmistaja(String nimi, String url) {
        Valmistaja valmistaja = new Valmistaja();
        valmistaja.setNimi(nimi);
        valmistaja.setUrl(url);
        valmistajaRepository.save(valmistaja);
    }

    public void updateValmistaja(Long id, String nimi, String url) {
        Valmistaja valmistaja = valmistajaRepository.getById(id);
        valmistaja.setNimi(nimi);
        valmistaja.setUrl(url);
        valmistajaRepository.save(valmistaja);
    }

    @Transactional
    public void deleteOneValmistaja(Long valmistajaID) {
        Valmistaja valmistaja = valmistajaRepository.findById(valmistajaID)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + valmistajaID));
        valmistajaRepository.delete(valmistaja);
    }

    public Valmistaja findValmistaja(Long id) {
        Valmistaja valmistaja = valmistajaRepository.getById(id);
        return valmistaja;
    }

    



}
