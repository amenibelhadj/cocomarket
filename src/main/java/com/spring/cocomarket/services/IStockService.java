package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Stock;
import com.spring.cocomarket.entities.Stock;

import java.util.List;

public interface IStockService {
    public Stock ajouterStock(Stock stock);
    public Stock modifierStock(Stock stock);
    public List<Stock> afficherListeStock();
    public void deleteStock(int id);
    public Stock retrieveStock(int id);
}
