package com.spring.cocomarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;



    public Categorie(String type){
        this.type=type;
        subCategories=new ArrayList<>();
    }
    public List<Categorie> getSubCategories() {
        return subCategories;
    }
    public void addSubCategory(Categorie category) {
        subCategories.add(category);
    }


    /*  @ManyToOne
       @JoinColumn(name = "parent_id")
       private Categorie parent; */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private List<Categorie> subCategories = new ArrayList<>();

  /*  @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Categorie> children = new ArrayList<Categorie>();

*/


    @OneToMany(cascade = CascadeType.ALL,mappedBy="categorie")
    @JsonIgnore
    @ToString.Exclude
    private Set<Produit>produits;




     /*@OneToMany(cascade = CascadeType.ALL,mappedBy="categorie")
    @JsonIgnore
    @ToString.Exclude
    private Set<SousCategorie> sousCategories; */
}
