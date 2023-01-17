package com.example.coffeeshop.model;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tuote extends AbstractPersistable<Long>{
    private String nimi;
    private String kuvaus;
    private BigDecimal hinta;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private byte[] tuotekuva;


    @ManyToOne
    private Toimittaja toimittaja;
    @ManyToOne
    private Valmistaja valmistaja;
    @ManyToOne
    private Osasto osasto;


    
}