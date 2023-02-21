package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface OffreRepo extends JpaRepository<Offre, Integer>  {

}
