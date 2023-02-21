package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface LivraisonRepo extends JpaRepository<Livraison, Integer>  {

}
