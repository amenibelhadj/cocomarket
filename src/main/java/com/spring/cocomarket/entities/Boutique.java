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
public class Boutique implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private String description;
    private String logo;
    private Integer productsNumber;
    private Integer IBAN;
    private Integer BIC;
    @ManyToOne
    @ToString.Exclude
    User user;
    @ManyToMany(mappedBy="boutiques",cascade =CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Produit> produits;
}
