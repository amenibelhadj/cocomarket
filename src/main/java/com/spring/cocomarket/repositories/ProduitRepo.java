package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface ProduitRepo extends JpaRepository<Produit, Integer>  {

}
