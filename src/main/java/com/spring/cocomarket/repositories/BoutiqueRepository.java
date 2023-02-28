package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoutiqueRepository extends JpaRepository<Boutique,Integer> {
}