
package com.spring.cocomarket.controllers;

import com.spring.cocomarket.interfaces.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"*"})

@RestController

public class AppelOffreController {
	@Autowired
    AppelOffreService AppelOffreService ;
}


