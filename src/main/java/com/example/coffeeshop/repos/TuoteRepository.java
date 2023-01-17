package com.example.coffeeshop.repos;

import java.util.List;

import com.example.coffeeshop.model.Tuote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TuoteRepository extends JpaRepository<Tuote, Long> {
    
    @Query(
    value = "SELECT TOP 18 * FROM Tuote WHERE Tuote.osasto_id = 1 OR Tuote.osasto_id = 3 OR Tuote.osasto_id = 4 OR Tuote.osasto_id = 5",
    nativeQuery = true)
    List<Tuote> findAllmachines();

    @Query(
    value = "SELECT TOP 18 * FROM Tuote WHERE Tuote.osasto_id = 2 OR Tuote.osasto_id > 5",
    nativeQuery = true)
    List<Tuote> findAllproducts();

    @Query(
    value = "SELECT * FROM Tuote t WHERE lower(t.nimi) LIKE %:hakusana% AND t.osasto_id <> 2 AND t.osasto_id <= 5",
    nativeQuery = true)
    List<Tuote> findMachineWithSearchIgnoreCase(@Param("hakusana") String hakusana);

    @Query(
    value = "SELECT * FROM Tuote t WHERE (lower(t.nimi) LIKE %:hakusana% AND t.osasto_id > 5) OR (lower(t.nimi) LIKE %:hakusana% AND t.osasto_id = 2)",
    nativeQuery = true)
    List<Tuote> findProductWithSearchIgnoreCase(@Param("hakusana") String hakusana);

}
