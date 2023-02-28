package com.spring.cocomarket.interfaces;

import com.spring.cocomarket.entities.Produit;

import java.util.List;

public interface IProduitService {
    public Produit ajouterProduit(Produit produit);
    public Produit modifierProduit(Produit produit);
    public List<Produit> afficherListeProduit();
    public void deleteProduit(int id);
    public Produit retrieveProduit(int id);
    public void ProduitAffectBoutique(Integer idProduit, Integer idBoutique);
}