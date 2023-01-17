package com.example.coffeeshop.repos;

import com.example.coffeeshop.model.Valmistaja;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ValmistajaRepository extends JpaRepository<Valmistaja, Long>{
    
    
}
