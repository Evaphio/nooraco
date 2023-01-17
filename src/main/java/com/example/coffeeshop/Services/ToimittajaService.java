package com.example.coffeeshop.Services;

import java.util.List;
import javax.transaction.Transactional;


import com.example.coffeeshop.model.Toimittaja;
import com.example.coffeeshop.repos.ToimittajaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service
public class ToimittajaService {
    
    @Autowired
    private ToimittajaRepository toimittajaRepository;

    public List<Toimittaja> getAllToimittajat() {
        return toimittajaRepository.findAll();
    }

    //add new delivery to the database
    public void addToimittaja(@ModelAttribute Toimittaja toimittaja) {
        toimittajaRepository.save(toimittaja);
    }
     
    public void updateToimittaja(Long id, String nimi, String yhteyshenkilo, String yhteyshenkilonEmail) {
        Toimittaja toimittaja = toimittajaRepository.getById(id);
        toimittaja.setNimi(nimi);
        toimittaja.setYhteyshenkilo(yhteyshenkilo);
        toimittaja.setYhteyshenkilonEmail(yhteyshenkilonEmail);
        toimittajaRepository.save(toimittaja);
        
    }

    @Transactional
    public void deleteOneToimittaja(Long toimittajaID) {
        Toimittaja toimittaja = toimittajaRepository.findById(toimittajaID)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + toimittajaID));
        toimittajaRepository.delete(toimittaja);
    }

    public Toimittaja findToimittaja(Long id) {
        Toimittaja toimittaja = toimittajaRepository.getById(id);
        return toimittaja;
    }

}
