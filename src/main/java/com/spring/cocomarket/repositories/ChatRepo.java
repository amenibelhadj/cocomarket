package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface ChatRepo extends JpaRepository<Chat, Integer>  {

}