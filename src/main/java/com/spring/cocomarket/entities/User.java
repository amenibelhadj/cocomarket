package com.spring.cocomarket.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
@Builder
public class User implements java.io.Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "First Name is mandatory")
    private String firstname;
    @NotBlank(message = "Last Name is mandatory")
    private String lastname;
    @Email(message = "Valid email address is mandatory")
    @NotBlank(message = "Email is mandatory")
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

    /////////////SPRING SECURITY + JWT/////////////////////////////
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(role.name()));
        return list;
    }
    @Override
    public String getUsername() {return email;}
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isAccountNonExpired() {return true;}
    @Override
    public boolean isAccountNonLocked() {return true;}
    @Override
    public boolean isCredentialsNonExpired() {return true;}
    @Override
    public boolean isEnabled() {return true;}
}
