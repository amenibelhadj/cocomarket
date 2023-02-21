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
public class SAV implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private SAVStatus status;
    @Enumerated(EnumType.STRING)
    private SAVType type;
    @ManyToOne
    @ToString.Exclude
    Commande commande;
}
