package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface SousCategorieRepo extends JpaRepository<SousCategorie, Integer>  {

}
