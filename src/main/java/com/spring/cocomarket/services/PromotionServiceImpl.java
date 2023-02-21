package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Produit;
import com.spring.cocomarket.entities.Promotion;
import com.spring.cocomarket.entities.Stock;
import com.spring.cocomarket.interfaces.PromotionService;
import com.spring.cocomarket.repositories.ProduitRepo;
import com.spring.cocomarket.repositories.PromotionRepo;
import com.spring.cocomarket.repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.spring.cocomarket.entities.PromotionType.EVENT;
import static com.spring.cocomarket.entities.PromotionType.QUANTITY;
import static sun.security.x509.InvalidityDateExtension.DATE;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	PromotionRepo Promotionrepo;
	//@Override

	@Autowired
	StockRepo stockRepo ;

	@Autowired
	ProduitRepo produitRepo ;


	public Promotion AddRealisationPromotion (Promotion Promotion){

		return Promotionrepo.save(Promotion) ;

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
		List<Integer> idsStDate30 = new ArrayList<>() ;
		Year currentYear = Year.now();
		int year = currentYear.getValue();

		LocalDate now = LocalDate.now();

		//realisation de promotion tous se fait automatiquement


		//Promotion par stock a9al mil 50 produits 10%
		stockRepo.findAll().stream()
				.filter(st -> st.getQuantity()<= 50)
				.map(st-> st.getProduits().stream().map(produit -> idsSt50.add(produit.getId())))
				.collect(Collectors.toSet());
		List<Produit> produitsProm50 =produitRepo.findAllById(idsSt50);
		produitsProm50.stream()
				.map(pr->{pr.setPrice((float) (pr.getPrice()*0.9)) ;
					return pr;
				})

				.collect(Collectors.toSet());



		//Promotion par date sup a 90 mise promotion de 10%
		stockRepo.findAll().stream()
				.filter(st->ChronoUnit.DAYS.between(st.getDateMise(), now) >= 90)
				.map(st-> st.getProduits().stream().map(produit -> idsStDate90.add(produit.getId())))
				.collect(Collectors.toSet());

		List<Produit> produitsPromDate90 =produitRepo.findAllById(idsStDate90);
		produitsPromDate90.stream()
				.map(pr->{pr.setPrice((float) (pr.getPrice()*0.90)) ;
					return pr;
				})
				.collect(Collectors.toSet());





		//promotion par date il a depassée 90% de validité de 30%

		stockRepo.findAll().stream()
				.filter(st-> ChronoUnit.DAYS.between(st.getDateMise(), now) >= 0.9 * ChronoUnit.DAYS.between(st.getDateMise(), st.getDateFin()))
				.map(st-> st.getProduits().stream().map(produit -> idsStDate90120.add(produit.getId())))
				.collect(Collectors.toSet());

		List<Produit> produitsPromDate90120 =produitRepo.findAllById(idsStDate90120);
		produitsPromDate90120.stream()
				.map(pr->{pr.setPrice((float) (pr.getPrice()*0.7)) ;
					return pr;
				})
				.collect(Collectors.toSet());





		//promotion sur les produits qui ont que 10 jours de validité de 40%
		stockRepo.findAll().stream()
				.filter(st->ChronoUnit.DAYS.between(now, st.getDateFin()) <= 20)
				.map(st-> st.getProduits().stream().map(produit -> idsStDate30.add(produit.getId())))
				.collect(Collectors.toSet());

		List<Produit> produitsPromDate30 =produitRepo.findAllById(idsStDate30);
		produitsPromDate30.stream()
				.map(pr->{pr.setPrice((float) (pr.getPrice()*0.60)) ;
					return pr;
				})
				.collect(Collectors.toSet());



		//Promotion 3iid l7ob par categorie promotion du 30%
		if(now.equals(LocalDate.of(year,2,14))){
				produitRepo.findAll().stream()
						.filter(pr-> (pr.getCategorie()).equals("Chocolat") || (pr.getCategorie()).equals("Cadeaux") || (pr.getCategorie()).equals("fllowers"))
						.map(pr->{pr.setPrice((float) (pr.getPrice()*0.7)) ;
							return pr;
						})
						.collect(Collectors.toSet());
		}

		//Promotion ras l3am 30%
		if(now.equals(LocalDate.of(year,1,1))){
			produitRepo.findAll().stream()
					.filter(pr-> (pr.getCategorie()).equals("Chocolat") || (pr.getCategorie()).equals("Cadeaux") || (pr.getCategorie()).equals("djaj"))
					.map(pr->{pr.setPrice((float) (pr.getPrice()*0.7)) ;
						return pr;
					})
					.collect(Collectors.toSet());
		}


		//Promotion ila zedthom eni
		Promotionrepo.findAll().stream()
				.filter(pr-> pr.getPromotionDate().equals(LocalDate.now()))
				.map(pr->pr.getStocks().stream().map(st->(st.getProduits()).stream().map(prod->{prod.setPrice((float) (prod.getPrice()*pr.getPourcentage())) ;
							return pr;
						})))
				.collect(Collectors.toSet());


	}

}
