package com.spring.cocomarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
public class User implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String company;
    private String address;
    private String logo;
    private Integer fidelity;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<ChatBox> chatBoxes;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="user")
    @JsonIgnore
    @ToString.Exclude
    private Set<Contrat> contrats;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="user")
    @JsonIgnore
    @ToString.Exclude
    private Set<Boutique> boutiques;

}
