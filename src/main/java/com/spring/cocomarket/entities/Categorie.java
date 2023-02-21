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
public class Categorie implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="categorie")
    @JsonIgnore
    @ToString.Exclude
    private Set<Produit>produits;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="categorie")
    @JsonIgnore
    @ToString.Exclude
    private Set<SousCategorie> sousCategories;
}
