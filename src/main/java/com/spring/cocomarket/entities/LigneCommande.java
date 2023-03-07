package com.spring.cocomarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
@Data
public class LigneCommande implements Serializable {

    @EmbeddedId
    private LigneCommandeKeyy ligneCommandeKeyy;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="commande_id",referencedColumnName = "id",insertable = false,updatable = false)
    @MapsId("commandeId")
    private Commande commande;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="produit_id",referencedColumnName = "id",insertable = false,updatable = false)
    @MapsId("produitId")
    private Produit produit;

    private int quantite;
    private int prixtot;


    public void setLigneCommandeKeyy(LigneCommandeKeyy ligneCommandeKeyy) {
        this.ligneCommandeKeyy = ligneCommandeKeyy;
    }
}
