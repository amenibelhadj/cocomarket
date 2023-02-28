package com.spring.cocomarket.services;

import com.spring.cocomarket.interfaces.BoutiqueService;
import com.spring.cocomarket.repositories.BoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BoutiqueServiceImpl implements BoutiqueService {
	@Autowired
	BoutiqueRepository boutiqueRepository;

	//@Override
		 
}
