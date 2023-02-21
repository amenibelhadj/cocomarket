package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface PanierRepo extends JpaRepository<Panier, Integer>  {

}
