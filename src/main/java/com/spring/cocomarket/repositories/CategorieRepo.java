package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface CategorieRepo extends JpaRepository<Categorie, Integer>  {

}
