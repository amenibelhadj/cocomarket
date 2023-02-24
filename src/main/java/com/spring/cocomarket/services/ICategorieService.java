package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Categorie;

import java.util.List;

public interface ICategorieService {
    public Categorie ajouterCategorie(Categorie categorie);
    public Categorie modifierCategorie(Categorie categorie);
    public List<Categorie> afficherListeCategories();
    public void deleteCategorie(int id);
    public Categorie retrieveCategorie(int id);
    //public void recursiveTree(Categorie categorie);
    public void addCategoryWithSubCategories(Categorie category);

}
