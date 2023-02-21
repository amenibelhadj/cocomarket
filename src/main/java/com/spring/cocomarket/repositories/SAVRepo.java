package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.SAV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface SAVRepo extends JpaRepository<SAV, Integer>  {

}
