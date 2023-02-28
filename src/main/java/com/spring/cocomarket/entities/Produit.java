package com.spring.cocomarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
public class Produit implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String image;
    private String description;
    private float price;
    private String color;
    private boolean promotion = false ;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Boutique> boutiques;

    @ManyToMany(mappedBy="produits",cascade =CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Panier>paniers;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Stock> stocks;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Catalogue catalogue;
    @ManyToOne
    @ToString.Exclude
    Categorie categorie;

}
