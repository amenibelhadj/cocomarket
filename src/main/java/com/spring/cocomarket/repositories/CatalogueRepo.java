package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface CatalogueRepo extends JpaRepository<Catalogue, Integer>  {

}
