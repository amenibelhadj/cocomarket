package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface StockRepo extends JpaRepository<Stock, Integer>  {

}
