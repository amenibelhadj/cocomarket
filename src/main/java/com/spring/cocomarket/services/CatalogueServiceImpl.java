package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Boutique;
import com.spring.cocomarket.entities.Catalogue;
import com.spring.cocomarket.interfaces.CatalogueService;
import com.spring.cocomarket.repositories.BoutiqueRepository;
import com.spring.cocomarket.repositories.CatalogueRepo;
import com.spring.cocomarket.repositories.ContratRepo;
import com.spring.cocomarket.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CatalogueServiceImpl implements CatalogueService {
	@Autowired
	CatalogueRepo Cataloguerepo;

	@Autowired
	ProduitRepository ProduitRepository ;

	@Autowired
	BoutiqueRepository boutiqueRepository ;
	@Autowired
	private ContratRepo contratRepo;

	public Catalogue GenerationCatalogueAll (){
		Catalogue catalogue = new Catalogue();
		catalogue.setDateCreation(LocalDate.now());
		catalogue.setProduits(ProduitRepository.findAll().stream().collect(Collectors.toSet()));
		catalogue.setName("AllCatalogue");
		return Cataloguerepo.save(catalogue) ;
		}

	public Catalogue GenerateCatalogueBoutique(Integer idBoutique){
		Catalogue catalogue = new Catalogue();
		Boutique boutique = boutiqueRepository.findById(idBoutique).orElse(null) ;
		if(boutique != null ) {
			catalogue.setDateCreation(LocalDate.now());
			catalogue.setProduits( boutique.getProduits());
			catalogue.setName(boutique.getDescription());


		}
		return  Cataloguerepo.save(catalogue) ;

	}

	 public Catalogue GenerateCataloguePromotion (){
		Catalogue catalogue = new Catalogue () ;
		 catalogue.setDateCreation(LocalDate.now());
		 catalogue.setProduits(ProduitRepository.findAll().stream().filter(pr-> pr.isPromotion()==true).collect(Collectors.toSet()));
		 catalogue.setName("Catalogue Promotion");
		 return  Cataloguerepo.save(catalogue) ;

	 }



}
