package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Commande;
import com.spring.cocomarket.entities.Livraison;
import com.spring.cocomarket.repositories.CommandeRepository;
import com.spring.cocomarket.repositories.LivraisonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LivraisonService implements ILivraisonService{
    private final LivraisonRepository livraisonRepository;
    private final CommandeRepository commandeRepository;

    @Override
    public List<Livraison> afficherLivraison() {
        return livraisonRepository.findAll();
    }

    @Override
    public Livraison addOrUpdateLivraison(Livraison L) {
        return livraisonRepository.save(L);
    }

    @Override
    public void removeLivraison(Integer idLiv) {
        livraisonRepository.deleteById(idLiv);

    }

    @Override
    public Livraison retrieveLivraison(Integer idLiv) {
        return livraisonRepository.findById(idLiv).orElse(null);
    }

    @Override
    public Livraison affecterLivraisonCommande(Integer idL, Integer idC) {
        Livraison l=livraisonRepository.findById(idL).orElse(null);
        Commande c=commandeRepository.findById(idC).orElse(null);

        l.setCommande(c);

        return livraisonRepository.save(l);
    }




}
