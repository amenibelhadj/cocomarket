package com.spring.cocomarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
public class Catalogue implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dateCreation;
    private String name ;

    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Produit> produits;
}
