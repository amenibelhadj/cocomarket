package com.spring.cocomarket.services;

import com.spring.cocomarket.entities.Promotion;
import com.spring.cocomarket.entities.SAV;
import com.spring.cocomarket.entities.SAVStatus;
import com.spring.cocomarket.entities.SAVType;
import com.spring.cocomarket.interfaces.SAVService;
import com.spring.cocomarket.repositories.SAVRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SAVServiceImpl implements SAVService {
	@Autowired
	SAVRepo SAVrepo;

	public SAV AddSav (SAV sav){

		return SAVrepo.save(sav);
	}
	public List<SAV> getAllSav (){
		return SAVrepo.findAll();
	}

	public Integer deleteSav (Integer id){
		SAVrepo.deleteById(id);
		return id;
	}

	public SAV updateSav (SAV sav , Integer Id){
		SAV SavUpdate = SAVrepo.findById(Id).orElse(null);
		SavUpdate.setDate(sav.getDate());
		SavUpdate.setType(sav.getType());
		SavUpdate.setStatus(sav.getStatus());
		SavUpdate.setDescription(sav.getDescription());
		return SAVrepo.save(SavUpdate) ;
	}
	public List<SAV> GetSavByType(SAVType Type){
		List<SAV> savs= SAVrepo.findAll();
		return savs.stream().filter(sav-> sav.getType().equals(Type))
				.collect(Collectors.toList());
	}

	public List<SAV> GetSavByStatus (SAVStatus Status){
		List<SAV> savs= SAVrepo.findAll();
		return savs.stream().filter(sav-> sav.getStatus().equals(Status))
				.collect(Collectors.toList());
	}



	//@Override
		 
}
