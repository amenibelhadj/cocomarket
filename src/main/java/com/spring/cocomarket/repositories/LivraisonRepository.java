package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<Livraison, Integer> {
}