package com.spring.cocomarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String image;
    private String description;
    private float price;
    private String color;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Boutique> boutiques;
    /*
    @ManyToMany(mappedBy="produits",cascade =CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Panier>paniers;*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Stock> stocks;
    /* @ManyToMany(mappedBy="produits",cascade =CascadeType.ALL)
     @JsonIgnore
     @ToString.Exclude
     private Set<Catalogue> catalogues; */
    @ManyToOne
    @ToString.Exclude
    Categorie categorie;
  /*  @ManyToMany(mappedBy="produits",cascade =CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Promotion> promotions; */

    @OneToMany(mappedBy="produit",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LigneCommande> lignesCommande;
}
