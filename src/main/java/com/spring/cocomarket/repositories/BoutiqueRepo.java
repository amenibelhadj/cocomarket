package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface BoutiqueRepo extends JpaRepository<Boutique, Integer>  {

}
