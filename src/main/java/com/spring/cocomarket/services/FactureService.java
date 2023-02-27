package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Commande;
import com.spring.cocomarket.entities.Facture;
import com.spring.cocomarket.repositories.CommandeRepository;
import com.spring.cocomarket.repositories.FactureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureService implements IFactureService {
    private final FactureRepository factureRepository;
    private final CommandeRepository commandeRepository;
    @Override
    public List<Facture> afficherFacture() {
        return factureRepository.findAll();
    }

    @Override
    public Facture addOrUpdateFacture(Facture F) {
        return factureRepository.save(F);
    }

    @Override
    public void removeFacture(Integer idF) {
        factureRepository.deleteById(idF);

    }

    @Override
    public Facture retrieveFacture(Integer idF) {
        return factureRepository.findById(idF).orElse(null);
    }

    @Override
    public Facture affecterFactureCommande(Integer idF, Integer idC) {
        Facture f=factureRepository.findById(idF).orElse(null);
        Commande c=commandeRepository.findById(idC).orElse(null);

        f.setCommande(c);
        return factureRepository.save(f);
    }

}
