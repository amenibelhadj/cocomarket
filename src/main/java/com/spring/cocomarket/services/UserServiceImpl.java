package com.spring.cocomarket.services;

import com.spring.cocomarket.interfaces.UserService;
import com.spring.cocomarket.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo Userrepo;

	//@Override
		 
}
