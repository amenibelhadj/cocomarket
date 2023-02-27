package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.LigneCommande;
import com.spring.cocomarket.entities.LigneCommandeKeyy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandeKeyy> {

    @Query("select p from LigneCommande p where p.produit.name=:x and p.commande.id=:num")
    public LigneCommande findLcByProduit(@Param("num")Integer numCommande, @Param("x")String ref );

    @Query("select p from LigneCommande p where p.produit.id=:x and p.commande.id=:num")
    public LigneCommande findLcByProduitt(@Param("num")Integer numCommande, @Param("x")Integer id );

    //LigneCommande findByIdProduitAndNumeroCommande(Long idProduit, Long numeroCommande);
    //LigneCommande findByIdProduitAndNumeroCommande(Integer produitId, Integer commandeId);

}
