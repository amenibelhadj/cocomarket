package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Promotion;
import com.spring.cocomarket.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface PromotionRepo extends JpaRepository<Promotion, Integer>  {

   // List<Promotion> findByStock(Stock stock);
}
