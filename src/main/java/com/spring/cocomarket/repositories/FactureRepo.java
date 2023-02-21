package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface FactureRepo extends JpaRepository<Facture, Integer>  {

}
