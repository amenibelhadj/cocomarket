package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface UserRepo extends JpaRepository<User, Integer>  {

}
