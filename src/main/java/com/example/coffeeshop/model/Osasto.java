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
public class Osasto extends AbstractPersistable<Long> {
    private String nimi;
    private Long osastoIDP;

    @OneToMany(mappedBy = "osasto")
    private List<Tuote> osastonTuotteet;
}
