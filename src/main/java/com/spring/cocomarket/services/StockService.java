package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Stock;
import com.spring.cocomarket.interfaces.IStockService;
import com.spring.cocomarket.repositories.StockRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class StockService implements IStockService {
    StockRepository stockRepository;
    @Override
    public Stock ajouterStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock modifierStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> afficherListeStock() {
        return stockRepository.findAll();
    }

    @Override
    public void deleteStock(int id) {
        stockRepository.deleteById(id);

    }

    @Override
    public Stock retrieveStock(int id) {
        return stockRepository.findById(id).orElse(null);
    }
}