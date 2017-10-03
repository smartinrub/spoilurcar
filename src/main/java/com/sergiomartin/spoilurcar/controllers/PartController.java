package com.sergiomartin.spoilurcar.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiomartin.spoilurcar.models.Part;
import com.sergiomartin.spoilurcar.repositories.PartRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PartController {

	@Autowired
	PartRepository partRespository;
	
	@PostMapping("/cars/parts/{id}")
	public ResponseEntity<Part> createPart(@PathVariable("id") String carId, 
			@Valid @RequestBody Part part) {
		partRespository.createPartByCarId(carId, part);
		
		return new ResponseEntity<>(part, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cars/parts/{id}/{name}")
	public void getAllCars(@PathVariable("id") String carId, 
			@PathVariable("name") String partName) {
		partRespository.deletePartByCarId(carId, partName);
	}
	
}
