package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
}
