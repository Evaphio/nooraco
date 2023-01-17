package com.example.coffeeshop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Valmistaja extends AbstractPersistable<Long>{
    private String nimi;
    private String url;
    
    @OneToMany(mappedBy = "valmistaja")
    private List<Tuote> tuotteet;
}
