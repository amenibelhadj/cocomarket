package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Commande;

import java.util.List;

public interface ICommandeService {
    List<Commande> afficherAllCommande();

    Commande addOrUpdateCommande(Commande c);

    void removeCommande(Integer id);

    Commande retrieveCommande(Integer id);

  //  public Commande affecterCommandeToPanier(Integer idC, Integer idP);
  //  public Commande ajouterETaffecterCommandeToPanier(Commande c, Integer idP);

}
