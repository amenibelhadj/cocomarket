package com.spring.cocomarket.services;

import com.spring.cocomarket.interfaces.ChatService;
import com.spring.cocomarket.repositories.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	ChatRepo Chatrepo;

	//@Override
		 
}
