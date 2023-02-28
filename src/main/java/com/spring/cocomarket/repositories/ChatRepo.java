package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.Chat;
import com.spring.cocomarket.entities.ChatBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepo extends JpaRepository<Chat, Integer> {
}
