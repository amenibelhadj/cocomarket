package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface CommandeRepo extends JpaRepository<Commande, Integer>  {

}
