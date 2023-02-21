package com.spring.cocomarket.repositories;


import com.spring.cocomarket.entities.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface AppelOffrerRepo extends JpaRepository<AppelOffre, Integer>  {

}
