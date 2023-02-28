package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Catalogue;
import com.spring.cocomarket.entities.Produit;
import com.spring.cocomarket.entities.Promotion;
import com.spring.cocomarket.interfaces.PromotionService;
import com.spring.cocomarket.repositories.CatalogueRepo;
import com.spring.cocomarket.repositories.ProduitRepository;
import com.spring.cocomarket.repositories.PromotionRepo;
import com.spring.cocomarket.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	PromotionRepo Promotionrepo;
	//@Override

	@Autowired
	StockRepository stockRepository ;

	@Autowired
	ProduitRepository produitRepository ;

	@Autowired
	CatalogueRepo CatalogueRepository ;

	public Promotion AddRealisationPromotion (Promotion promotion){
		return Promotionrepo.save(promotion) ;

	}
	public List<Promotion> getAllPromotion (){

		return Promotionrepo.findAll();
	}

	public Promotion UpdatePromotion (Promotion newPromotion , Integer id){
		Promotion promotionToUpdate = Promotionrepo.findById(id).orElse(null);
		promotionToUpdate.setPromotionDate(newPromotion.getPromotionDate());
		//promotionToUpdate.setStocks(newPromotion.getStocks());
		promotionToUpdate.setNom(newPromotion.getNom());
		promotionToUpdate.setDescription(newPromotion.getDescription());
		promotionToUpdate.setPourcentage(newPromotion.getPourcentage());
		return Promotionrepo.save(promotionToUpdate);

	}

	public Integer deletePromotion (Integer id){
		Promotionrepo.deleteById(id);
		return id;
	}


	@Scheduled (cron ="0 0 12 * * ?")
	public void RealisationPromotion() {
		List<Integer> idsSt50 = new ArrayList<>() ;
		List<Integer> idsStDate90 = new ArrayList<>() ;
		List<Integer> idsStDate90120 = new ArrayList<>() ;
		List<Integer> idsStDate95120 = new ArrayList<>() ;

		List<Integer> idsStDate30 = new ArrayList<>() ;
		Year currentYear = Year.now();
		int year = currentYear.getValue();
		Catalogue newCatalogue = new Catalogue();
		LocalDate now = LocalDate.now();

		//realisation de promotion tous se fait automatiquement





		//Promotion 3iid l7ob par categorie promotion du 30%
		if(now.equals(LocalDate.of(year,2,14))){
			List<Produit> produitsL7ob = produitRepository.findAll().stream()

					.filter(pr-> ((pr.getCategorie()).equals("Chocolat") || (pr.getCategorie()).equals("Cadeaux") || (pr.getCategorie()).equals("fllowers")))
					.map(pr->{

						pr.setPrice((float) (pr.getPrice()*0.7)) ;
						pr.setPromotion(true);

						if(now.equals(LocalDate.of(year,2,15))){
							pr.setPromotion(false);
							pr.setPrice((float) (pr.getPrice()*1.3)) ;

						}
						return pr;
					})
					.collect(Collectors.toList());
			/*if (produitsL7ob!=null) {
				newCatalogue.setProduits(produitsL7ob.stream().collect(Collectors.toSet()));
				newCatalogue.setDateCreation(LocalDate.now());
				newCatalogue.setName("Catalogue 3id l7ob");
				CatalogueRepository.save(newCatalogue);
			}*/
		}




		//Promotion ras l3am 30%
		if(now.equals(LocalDate.of(year,1,1))){
			List<Produit> produitsRasL3am =produitRepository.findAll().stream()
					.filter(pr-> ((pr.getCategorie()).equals("Chocolat") || (pr.getCategorie()).equals("Cadeaux") || (pr.getCategorie()).equals("djaj")))
					.map(pr->{
						if(now.equals(LocalDate.of(year,12,31))){
							pr.setPromotion(false);
						}
						pr.setPrice((float) (pr.getPrice()*0.7)) ;
						pr.setPromotion(true);
						if(now.equals(LocalDate.of(year,2,1))){
							pr.setPromotion(false);
							pr.setPrice((float) (pr.getPrice()*1.3)) ;

						}
						return pr;
					})
					.collect(Collectors.toList());

		/*	if (produitsRasL3am!=null) {
				newCatalogue.setProduits(produitsRasL3am.stream().collect(Collectors.toSet()));
				newCatalogue.setDateCreation(LocalDate.now());
				newCatalogue.setName("Catalogue ras l3am");
				CatalogueRepository.save(newCatalogue);
			}*/
		}





		//Promotion par stock a9al mil 50 produits 10%
		stockRepository.findAll().stream()
				.filter(st -> st.getQuantity()<= 50)
				.map(st-> st.getProduits().stream().map(produit -> idsSt50.add(produit.getId())))
				.collect(Collectors.toSet());
		List<Produit> produitsProm50 = produitRepository.findAllById(idsSt50);
		produitsProm50.stream()
				.filter(pr-> pr.isPromotion() == false )
				.map(pr->{pr.setPrice((float) (pr.getPrice()*0.9)) ;
					pr.setPromotion(true);

					return pr;
				})

				.collect(Collectors.toSet());
/*if (produitsProm50!=null ) {
	newCatalogue.setProduits(produitsProm50.stream().collect(Collectors.toSet()));
	newCatalogue.setDateCreation(LocalDate.now());
	newCatalogue.setName("Catalogue stock - 50");
	CatalogueRepository.save(newCatalogue);
}*/


		//promotion par date il a depassée 90% de validité de 30%

		stockRepository.findAll().stream()
				.filter(st-> ChronoUnit.DAYS.between(st.getDateMise(), now) >= 0.9 * ChronoUnit.DAYS.between(st.getDateMise(), st.getDateFin()))
				.map(st-> st.getProduits().stream().map(produit -> idsStDate90120.add(produit.getId())))
				.collect(Collectors.toSet());

		List<Produit> produitsPromDate90120 =produitRepository.findAllById(idsStDate90120);
		produitsPromDate90120.stream()
				.filter(pr-> pr.isPromotion() == false )
				.map(pr->{pr.setPrice((float) (pr.getPrice()*0.7)) ;
					pr.setPromotion(true);

					return pr;
				})
				.collect(Collectors.toSet());

		/*if (produitsPromDate90120!=null) {
			newCatalogue.setProduits(produitsPromDate90120.stream().collect(Collectors.toSet()));
			newCatalogue.setDateCreation(LocalDate.now());
			newCatalogue.setName("Catalogue 90% validité");
			CatalogueRepository.save(newCatalogue);
		}
*/







		//Promotion ila zedthom eni
		Promotionrepo.findAll().stream()
				.filter(pr-> pr.getPromotionDate().equals(LocalDate.now()))
				.map(pr->pr.getStocks().stream().map(st->(st.getProduits()).stream().filter(prod-> prod.isPromotion()==false).map(prod->{prod.setPrice((float) (prod.getPrice()*pr.getPourcentage())) ;
							prod.setPromotion(true);

							return pr;
						})))
				.collect(Collectors.toSet());


	}

}
