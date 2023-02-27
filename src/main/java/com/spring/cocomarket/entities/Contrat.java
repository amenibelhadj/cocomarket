package com.spring.cocomarket.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
public class Contrat implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate start_date;
    private LocalDate end_date;
    private float price;
    @ManyToOne
    @ToString.Exclude
    User user;
    @OneToOne
    @ToString.Exclude
    private AppelOffre appelOffre;
}
