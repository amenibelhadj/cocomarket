package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Facture;

import java.util.List;

public interface IFactureService {

    List<Facture> afficherFacture();

    Facture addOrUpdateFacture(Facture F);


    void removeFacture(Integer idF);

    Facture retrieveFacture(Integer idF);

    public Facture affecterFactureCommande(Integer idF, Integer idC);
}
