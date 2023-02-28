package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.Produit;
import com.spring.cocomarket.interfaces.IProduitService;
import com.spring.cocomarket.services.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Produit")
@AllArgsConstructor
public class ProduitController {
    IProduitService produitService;

    @PostMapping("/ajouterProduit")
    Produit ajouterProduit(@RequestBody Produit p) {
        return produitService.ajouterProduit(p);
    }

    @PutMapping("/modifierProduit")
    Produit modifierProduit(@RequestBody Produit p) {
        return produitService.modifierProduit(p);
    }

    @GetMapping("/afficherProduits")
    List<Produit> afficherProduit() {
        return produitService.afficherListeProduit();
    }

    @DeleteMapping("/supprimerProduit/{id}")
    void supprimerProduit(@PathVariable int id) {
        produitService.deleteProduit(id);
    }

    @GetMapping("afficherProduit/{id}")
    Produit retriveProduit(@PathVariable int id) {
        return produitService.retrieveProduit(id);
    }

    @PutMapping("/affectProduitToBoutique/{idProduit}/{idBoutique}")
    void affecterProduitBoutique(Integer idProduit,Integer idBoutique)
    {
        produitService.ProduitAffectBoutique(idProduit, idBoutique);
    }

}