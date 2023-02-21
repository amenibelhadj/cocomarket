package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.ChatBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories


public interface ChatBoxRepo extends JpaRepository<ChatBox, Integer>  {

}
