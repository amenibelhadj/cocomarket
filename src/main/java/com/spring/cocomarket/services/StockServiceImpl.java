package com.spring.cocomarket.services;

import com.spring.cocomarket.interfaces.StockService;
import com.spring.cocomarket.repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockRepo Stockrepo;

	//@Override
		 
}
