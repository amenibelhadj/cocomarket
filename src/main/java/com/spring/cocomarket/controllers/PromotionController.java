
package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.Promotion;
import com.spring.cocomarket.entities.SAV;
import com.spring.cocomarket.entities.Stock;
import com.spring.cocomarket.repositories.PromotionRepo;
import com.spring.cocomarket.repositories.StockRepo;
import com.spring.cocomarket.services.PromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@CrossOrigin(origins = {"*"})

@RestController

@RequestMapping("/api/promotions")
public class PromotionController {

	@Autowired
	PromotionServiceImpl Promotionservice ;


	@PostMapping(value="/addPromotion", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Promotion addPromotion(@RequestBody Promotion promotion){
		return Promotionservice.AddRealisationPromotion(promotion);
			}

	@DeleteMapping("/removePromotion/{Id}")
	public Integer removePromotion(@PathVariable("Id") Integer Id){
		return Promotionservice.deletePromotion(Id);
	}

	@PutMapping(value="/updatePromotion/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Promotion UpdatePromotion(@RequestBody Promotion NewPromotion , @PathVariable("id") Integer Id ){
		return  Promotionservice.UpdatePromotion(NewPromotion, Id);
	}

	@GetMapping("/AllPromotion")
	public List<Promotion> getPromotion(){
		return Promotionservice.getAllPromotion();
	}




}


