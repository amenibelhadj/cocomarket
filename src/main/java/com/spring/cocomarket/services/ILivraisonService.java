package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Livraison;

import java.util.List;

public interface ILivraisonService {
    List<Livraison> afficherLivraison();

    Livraison addOrUpdateLivraison(Livraison L);


    void removeLivraison(Integer idLiv);

    Livraison retrieveLivraison(Integer idLiv);

    public Livraison affecterLivraisonCommande(Integer idL, Integer idC);


}
