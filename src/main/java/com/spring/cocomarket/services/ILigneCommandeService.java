package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.LigneCommande;
import com.spring.cocomarket.entities.LigneCommandeKeyy;

public interface ILigneCommandeService {
    public LigneCommande getLigneCommande(LigneCommandeKeyy id );
   // public LigneCommande getLigneCommandeByProduit( Integer numeroCommande, String name );

    //public LigneCommande getLigneCommandeByProduit( Integer numeroCommande, Integer id );
    public LigneCommande saveLigneCommande(LigneCommande ligneCommande);
    public LigneCommande updateLigneCommande(LigneCommande ligneCommande);
    public LigneCommande saveLigneCommandeK(LigneCommandeKeyy ligneCommandeKeyy);
    public boolean deleteLigneCommande(LigneCommandeKeyy id);


   // LigneCommande findByIdProduitAndNumeroCommande(Integer idProduit, Integer numeroCommande);
}
