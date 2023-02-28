package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Boutique;
import com.spring.cocomarket.entities.Produit;
import com.spring.cocomarket.interfaces.IProduitService;
import com.spring.cocomarket.repositories.BoutiqueRepository;
import com.spring.cocomarket.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor

public class ProduitService implements IProduitService {
    ProduitRepository produitRepository;
    BoutiqueRepository boutiqueRepository;
    @Override
    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit modifierProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> afficherListeProduit() {
        return produitRepository.findAll();
    }

    @Override
    public void deleteProduit(int id) {
        produitRepository.deleteById(id);

    }

    @Override
    public Produit retrieveProduit(int id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void ProduitAffectBoutique(Integer idProduit, Integer idBoutique) {
        Produit produit =produitRepository.findById(idProduit).orElse(null);
        Boutique boutique=boutiqueRepository.findById(idBoutique).orElse(null);
        produit.setBoutiques((Set<Boutique>) boutique);
        produitRepository.save(produit);

    }
}