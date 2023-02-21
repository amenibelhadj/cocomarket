package com.spring.cocomarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
public class Promotion implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private float pourcentage;
    private LocalDate PromotionDate;
    private String nom;
    private String description;








        @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
        @JsonIgnore
        @ToString.Exclude
        private Set<Stock> stocks;
        public Set<Stock> getStocks() {
            return stocks;
        }

        public void setStocks(Set<Stock> stocks) {
            this.stocks = stocks;
        }
    }


