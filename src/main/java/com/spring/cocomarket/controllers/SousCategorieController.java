
package com.spring.cocomarket.controllers;

import com.spring.cocomarket.interfaces.SousCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"*"})

@RestController

public class SousCategorieController {
	@Autowired
	SousCategorieService SousCategorieservice ;
}


