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
public class Commande implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private float amount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToOne
    @ToString.Exclude
    private Panier panier;
    @OneToOne(mappedBy="commande")
    @ToString.Exclude
    private Facture facture;
    @OneToOne(mappedBy="commande")
    @ToString.Exclude
    private Livraison livraison;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="commande")
    @JsonIgnore
    @ToString.Exclude
    private Set<SAV> savs;
}
