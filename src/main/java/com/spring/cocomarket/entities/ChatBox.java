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
public class ChatBox implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer nombrePartcipants;
    private LocalDate date;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="chatBox")
    @JsonIgnore
    @ToString.Exclude
    private Set<Chat> chats;
}
