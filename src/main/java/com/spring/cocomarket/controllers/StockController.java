package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.Stock;
import com.spring.cocomarket.interfaces.IStockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {
	IStockService stockService;
	@PostMapping("/ajouterstock")
	Stock ajouterstock(@RequestBody Stock s) {
		return stockService.ajouterStock(s);
	}

	@PutMapping("/modifierstock")
	Stock modifierstock(@RequestBody Stock s) {
		return stockService.modifierStock(s);
	}

	@GetMapping("/afficherstock")
	List<Stock> afficherstock() {
		return stockService.afficherListeStock();
	}

	@DeleteMapping("/supprimerstock/{id}")
	void supprimerstock(@PathVariable int id) {
		stockService.deleteStock(id);
	}

	@GetMapping("afficherstock/{id}")
	Stock retrivestock(@PathVariable int id) {
		return stockService.retrieveStock(id);
	}
}