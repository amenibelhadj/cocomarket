package com.spring.cocomarket.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LigneCommandeKeyy implements Serializable {

    @Column(name = "commande_id")
    private Integer commandeId;
    @Column(name = "produit_id")
    private Integer produitId;


    public LigneCommandeKeyy(Integer idProduit, Integer numeroCommande) {
        this.produitId = idProduit;
        this.commandeId = numeroCommande;
    }

    public LigneCommandeKeyy() {

    }
    public Integer getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Integer commandeId) {
        this.commandeId = commandeId;
    }

    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommandeKeyy that = (LigneCommandeKeyy) o;
        return Objects.equals(commandeId, that.commandeId) && Objects.equals(produitId, that.produitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandeId, produitId);
    }
}
