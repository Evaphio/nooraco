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
public class Toimittaja extends AbstractPersistable<Long>{

    private String nimi;
    private String yhteyshenkilo;
    private String yhteyshenkilonEmail;

    @OneToMany(mappedBy = "toimittaja")
    private List<Tuote> tuotteet;

    
}
