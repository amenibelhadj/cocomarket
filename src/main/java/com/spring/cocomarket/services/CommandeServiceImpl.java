package com.spring.cocomarket.services;

import com.spring.cocomarket.interfaces.CommandeService;
import com.spring.cocomarket.repositories.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	CommandeRepo Commanderepo;

	//@Override
		 
}
