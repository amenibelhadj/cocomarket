package com.spring.cocomarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
public class Commande implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private float amount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDate date;
    private Integer quantity;


/*
    @OneToOne
    @ToString.Exclude
    @JsonIgnore
    private Panier panier; */

    @OneToOne(mappedBy="commande")
    @ToString.Exclude
    @JsonIgnore
    private Facture facture;

    @OneToOne(mappedBy="commande")
    @ToString.Exclude
    @JsonIgnore
    private Livraison livraison;



    @OneToMany(cascade = CascadeType.ALL,mappedBy="commande")
    @JsonIgnore
    @ToString.Exclude
    private Set<SAV> savs;

   /* @OneToMany(mappedBy="commande",fetch=FetchType.LAZY)
    private Set<LigneCommande> lignesCommande; */

    @OneToMany(mappedBy="commande",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LigneCommande> lignesCommande;
}
