package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Commande;
import com.spring.cocomarket.repositories.CommandeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeService implements ICommandeService{
    private final CommandeRepository commandeRepository;

    @Override
    public List<Commande> afficherAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addOrUpdateCommande(Commande c) {
        return commandeRepository.save(c);
    }

    @Override
    public void removeCommande(Integer id) {
        commandeRepository.deleteById(id);

    }

    @Override
    public Commande retrieveCommande(Integer id) {

        return commandeRepository.findById(id).orElse(null);
    }


  /*  public Commande affecterCommandeToPanier(Integer idC, Integer idP) {
        Commande c=commandeRepository.findById(idC).orElse(null);
        Panier p=panierRepository.findById(idP).orElse(null);

        c.setPanier(p);
        return commandeRepository.save(c);

         @Override
    public Commande ajouterETaffecterCommandeToPanier(Commande c, Integer idP) {
        Panier p=panierRepository.findById(idP).orElse(null);

        c.setPanier(p);
        commandeRepository.save(c);
        return c;
    }
    }*/



}





