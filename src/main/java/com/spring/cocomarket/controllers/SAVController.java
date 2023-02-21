
package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.Promotion;
import com.spring.cocomarket.entities.SAV;
import com.spring.cocomarket.entities.SAVStatus;
import com.spring.cocomarket.entities.SAVType;
import com.spring.cocomarket.interfaces.SAVService;
import com.spring.cocomarket.services.SAVServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})

@RestController
@RequestMapping("/api/Sav")
public class SAVController {
	@Autowired
	SAVServiceImpl SAVservice ;

	@PostMapping(value="/addSav", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SAV addPromotion(@RequestBody SAV Sav){
		return SAVservice.AddSav(Sav);
	}

	@DeleteMapping("/removeSav/{Id}")
	public Integer removePromotion(@PathVariable("Id") Integer Id){
		return SAVservice.deleteSav(Id);
	}

	@GetMapping("/AllSav")
	public List<SAV> getSav(){
		return SAVservice.getAllSav();
	}


	@GetMapping("/SavType/{Type}")
	public List<SAV> getSavType(@PathVariable("Type") SAVType Type){
		return SAVservice.GetSavByType(Type) ;
	}


	@GetMapping("/SavStatus/{Status}")
	public List<SAV> getSavStatus(@PathVariable("Status") SAVStatus Status){
		return SAVservice.GetSavByStatus(Status) ;
	}

	@PutMapping(value="/updateSav/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SAV UpdatePromotion(@RequestBody SAV NewSav , @PathVariable("id") Integer Id ){
		return SAVservice.updateSav(NewSav , Id) ;
	}


}


