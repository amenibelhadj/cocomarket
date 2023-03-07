package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.*;
import com.spring.cocomarket.services.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//@RequiredArgsConstructor
@Slf4j
@AllArgsConstructor
public class controller {

    private final ILivraisonService iLivraisonService;
    private final ICommandeService iCommandeService;
    private final IFactureService iFactureService;
    private final IProduitService metierProduit;
    private final ILigneCommandeService iLigneCommande;


    @Autowired
    private HttpSession session;


///////////////////////LIVRAISON///////////////


    @PostMapping("/addLivr")
    Livraison addLiv(@RequestBody Livraison L) {
        return iLivraisonService.addOrUpdateLivraison(L);
    }

    @PostMapping("/UpdateLivr")
    Livraison updateLiv(@RequestBody Livraison L) {
        return iLivraisonService.addOrUpdateLivraison(L);
    }

    @GetMapping("/getLiv/{id}")
    Livraison getLivraison(@PathVariable("id") Integer id) {

        return iLivraisonService.retrieveLivraison(id);
    }

    @GetMapping("/allLiv")
    List<Livraison> getallLivraison() {
        return iLivraisonService.afficherLivraison();
    }

    @DeleteMapping("/deleteLiv/{id}")
    void deleteLivraison(@PathVariable("id") Integer id) {
        iLivraisonService.removeLivraison(id);
    }


    @PutMapping("/addLivraisonCommande/{idL}/{idC}")
    public Livraison affecterLivraisonCommande(
            @PathVariable("idL") Integer idL,
            @PathVariable("idC") Integer id) {
        return iLivraisonService.affecterLivraisonCommande(idL, id);

    }

    //////////////////////////COMMANDE/////////////

    @PostMapping("/addOrder")
    Commande addCommande(@RequestBody Commande c) {
        return iCommandeService.addOrUpdateCommande(c);
    }

    @PostMapping("/UpdateOrder")
    Commande updateComm(@RequestBody Commande c) {
        return iCommandeService.addOrUpdateCommande(c);
    }

    @GetMapping("/getOrder/{id}")
    Commande getorder(@PathVariable("id") Integer id) {
        return iCommandeService.retrieveCommande(id);
    }

    @GetMapping("/allOrders")
    List<Commande> getallOrders() {
        return iCommandeService.afficherAllCommande();
    }

    @DeleteMapping("/deleteOrder/{id}")
    void deleteOrder(@PathVariable("id") Integer id) {
        iCommandeService.removeCommande(id);
    }

   /* @PutMapping("/addOrderPanier/{idC}/{idP}")
    public Commande affecterCommandePanier(
            @PathVariable("idC") Integer idc,
            @PathVariable("idP") Integer idp){
        return iCommandeService.affecterCommandeToPanier(idc,idp);
    }
    @PostMapping("/addCommandePanier/{idPan}")
    public Commande ajouteretaffecterCommande(@RequestBody Commande c,
                                          @PathVariable("idPan") Integer idPan){
        iCommandeService.ajouterETaffecterCommandeToPanier(c,idPan);

        return null;

        }   */


    //////////////////////FACTURE/////////////
    @PostMapping("/addFacture")
    Facture addFact(@RequestBody Facture f) {
        return iFactureService.addOrUpdateFacture(f);
    }

    @PostMapping("/UpdateFacture")
    Facture UpdateFact(@RequestBody Facture f) {
        return iFactureService.addOrUpdateFacture(f);
    }

    @GetMapping("/getFacture/{id}")
    Facture getFact(@PathVariable("id") Integer id) {
        return iFactureService.retrieveFacture(id);
    }

    @GetMapping("/allFacture")
    List<Facture> getall() {
        return iFactureService.afficherFacture();
    }

    @DeleteMapping("/deleteFacture/{id}")
    void deleteFact(@PathVariable("id") Integer id) {
        iFactureService.removeFacture(id);
    }


    @PutMapping("/addFactureCommande/{idF}/{idC}")
    public Facture affecterFactureCommande(
            @PathVariable("idF") Integer idF,
            @PathVariable("idC") Integer id) {
        return iFactureService.affecterFactureCommande(idF, id);

    }


///////////////////////////////////LIGNE_Commande///////////////////

    @PostMapping("/addLIGNECOMMANDE/{idproduit}/{idcommande}/{q}")
    public LigneCommande addlignecommande(@RequestBody LigneCommande lc,
                                          @PathVariable("idproduit") Integer id,
                                          @PathVariable("idcommande") Integer idc ,
                                      @PathVariable("q") Integer q) {
        lc.setCommande(iCommandeService.retrieveCommande(idc));
        lc.setProduit(metierProduit.retrieveProduit(id));
         lc.setQuantite(q);
        lc.setPrixtot((int) (lc.getQuantite() * lc.getProduit().getPrice()));

        //  lc.setTotal( lc.getQte() * lc.getProduit().getPrix() );
        //  lc.setTtc( lc.getTotal() + (lc.getTotal()*lc.getProduit().getTva().getTaux())/100.0);

        return iLigneCommande.saveLigneCommande(lc);
    }


    @PutMapping("/UpdateLIGNECOMMANDE/{idpp}/{idC}/{q}")
    public LigneCommande aupdatelignecommande(
                                              @PathVariable("idpp") Integer idProduit,
                                              @PathVariable("idC") Integer numeroCommande,
                                              @PathVariable("q") Integer q) {

        LigneCommandeKeyy id = new LigneCommandeKeyy((idProduit), (numeroCommande));
        LigneCommande ligneCommande = iLigneCommande.getLigneCommande(id);


        ligneCommande.setQuantite(q);
        ligneCommande.setPrixtot((int) (ligneCommande.getQuantite() * ligneCommande.getProduit().getPrice()));
        ligneCommande.setCommande(iCommandeService.retrieveCommande(numeroCommande));
        ligneCommande.setProduit(metierProduit.retrieveProduit(idProduit));
        return iLigneCommande.updateLigneCommande(ligneCommande);

    }




    @DeleteMapping("/commandes/ligne/delete/{p}/{c}")
    void deleteLigneCommande( @PathVariable("p") Integer idProduit,
                              @PathVariable("c") Integer numeroCommande){

        LigneCommandeKeyy id = new LigneCommandeKeyy((idProduit), (numeroCommande));
        LigneCommande ligneCommande = iLigneCommande.getLigneCommande(id);

        iLigneCommande.deleteLigneCommande(id);


    }




}







    ///////////////////////////PANIERR////////////////////
 /*
    @PostMapping("/addCart")
    Panier addPanier(@RequestBody Panier p){
        return iPanierService.addOrUpdatePanier(p);
    }

    @PutMapping("/updateCart")
    Panier UpdatePanier(@RequestBody Panier p){
        return iPanierService.addOrUpdatePanier(p);
    }

    @GetMapping("/getCart/{id}")
    Panier getPanier(@PathVariable("id") Integer id){
        return iPanierService.retrievePanier(id);
    }

    @GetMapping("/allCarts")
    List<Panier> getallPaniers(){
        return iPanierService.afficherAllPanier();
    }

    @DeleteMapping("/deleteCart/{id}")
    void deletePanier(@PathVariable("id") Integer id){
        iPanierService.removePanier(id);}

    @PutMapping("/addProductToCart/{idProduit}/{idPanier}")
    public Panier affecterProduitToPanier(
            @PathVariable("idProduit") Integer idP,
            @PathVariable("idPanier") Integer id){
        return iPanierService.affecterProduitToPanier(idP,id);
    }

    @PostMapping("/addPanierProduit/{idProd}")
    public Panier ajouteretaffecterPanier(@RequestBody Panier p,
                                          @PathVariable("idProd") Integer idProd){
        iPanierService.ajouterPanierEtAffecterProduit(p,idProd);
        return null;
    }

*/












