package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
}