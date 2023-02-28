
package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.Catalogue;
import com.spring.cocomarket.entities.Stock;
import com.spring.cocomarket.interfaces.CatalogueService;
import com.spring.cocomarket.services.CatalogueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = {"*"})

@RestController

public class CatalogueController {
	@Autowired
	CatalogueServiceImpl Catalogueservice ;

	@GetMapping("/afficherTousCatalogue")
	Catalogue afficherAllCatalogue() {
		return Catalogueservice.GenerationCatalogueAll();
	}

	@GetMapping("afficherCatalogueBoutique/{id}")
	Catalogue retriveCatalogueBoutique(@PathVariable int id) {
		return Catalogueservice.GenerateCatalogueBoutique(id);
	}


	@GetMapping("/afficherCataloguePromotion")
	Catalogue afficherCataloguePromotion() {
		return Catalogueservice.GenerateCataloguePromotion();
	}
}


