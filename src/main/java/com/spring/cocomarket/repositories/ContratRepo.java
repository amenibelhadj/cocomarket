package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface ContratRepo extends JpaRepository<Contrat, Integer>  {

}
