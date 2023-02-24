package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer>{
    // List<Categorie> findByParentIsNull();

}
