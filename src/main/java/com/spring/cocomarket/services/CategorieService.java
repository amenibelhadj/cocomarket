package com.spring.cocomarket.services;


import com.spring.cocomarket.entities.Categorie;
import com.spring.cocomarket.interfaces.ICategorieService;
import com.spring.cocomarket.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CategorieService implements ICategorieService {
    CategorieRepository categorieRepository;

    @Override
    public Categorie ajouterCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie modifierCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> afficherListeCategories() {
        return categorieRepository.findAll();
      /*  List<Categorie> categoryList = categorieRepository.findAll();
       // List<Categorie> categoryList = categorieRepository.findByPParentIsNull();

        for (Categorie categorie : categoryList) {
            recursiveTree(categorie);
        }
        return categoryList;*/
        // return categorieRepository.findByParentIsNull();

    }

    @Override
    public void deleteCategorie(int id) {
        categorieRepository.deleteById(id);

    }

    @Override
    public Categorie retrieveCategorie(int id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public void addCategoryWithSubCategories(Categorie category) {

    }


    //  List<Categorie> categoryList = categorieRepository.findAll();

    /*  for (Categorie categorie : categoryList) {
           recursiveTree(categorie);
       } */


 /*  @Transactional
    public void recursiveTree(Categorie categorie) {

            System.out.println(categorie.getType());
            if (categorie.getChildren().size() > 0) {
                for (Categorie c : categorie.getChildren()) {
                    recursiveTree(c);
                }
            }

        }*/

    /*  @Transactional
      public void addCategoryWithSubcategories(Categorie categorie) {
          if (categorie.getChildren() != null && !categorie.getChildren().isEmpty()) {
              for (Categorie subcategory : categorie.getChildren()) {
                  subcategory.setParent(categorie);
                  addCategoryWithSubcategories(subcategory);
              }
          }
          categorieRepository.save(categorie);
      }*/
   /* @Override
    public void addCategoryWithSubCategories(Categorie category) {
        addSubCategories(category);
        categorieRepository.save(category);
    }*/

   /* private void addSubCategories(Categorie category) {
        for (Categorie subCategory : category.getSubCategories()) {
            addSubCategories(subCategory);
            categorieRepository.save(subCategory);
        }*/
    }












