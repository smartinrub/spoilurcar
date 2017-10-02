package com.sergiomartin.spoilurcar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiomartin.spoilurcar.repositories.PartRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PartController {

	@Autowired
	PartRepository partRespository;
	
	@DeleteMapping("/cars/parts/{id}/{name}")
	public void getAllCars(@PathVariable("id") String carId, 
			@PathVariable("name") String partName) {
		partRespository.deletePartByCarId(carId, partName);
	}
	
}
