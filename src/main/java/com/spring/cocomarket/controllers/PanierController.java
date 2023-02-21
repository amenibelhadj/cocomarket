
package com.spring.cocomarket.controllers;

import com.spring.cocomarket.interfaces.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"*"})

@RestController

public class PanierController {
	@Autowired
	PanierService Panierservice ;
}


