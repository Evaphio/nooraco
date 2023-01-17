package com.example.coffeeshop.repos;

import java.util.List;

import com.example.coffeeshop.model.Toimittaja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToimittajaRepository extends JpaRepository<Toimittaja, Long> {

   List<Toimittaja> findByNimi(String nimi);
}
