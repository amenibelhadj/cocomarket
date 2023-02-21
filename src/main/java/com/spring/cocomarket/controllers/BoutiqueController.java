
package com.spring.cocomarket.controllers;

import com.spring.cocomarket.interfaces.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"*"})

@RestController

public class BoutiqueController {
	@Autowired
	BoutiqueService Boutiqueservice ;




}


