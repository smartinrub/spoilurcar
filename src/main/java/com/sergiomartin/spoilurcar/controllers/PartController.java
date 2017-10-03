package com.sergiomartin.spoilurcar.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiomartin.spoilurcar.models.Car;
import com.sergiomartin.spoilurcar.models.Part;
import com.sergiomartin.spoilurcar.repositories.CarRepository;
import com.sergiomartin.spoilurcar.repositories.PartRepositoryCustom;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PartController {

	@Autowired
	PartRepositoryCustom partRespositoryCustom;
	
	@Autowired
	CarRepository carRepository;
	
	
	@PostMapping("/cars/parts/{id}")
	public ResponseEntity<Part> createPart(@PathVariable("id") String carId, 
			@Valid @RequestBody Part part) {
		partRespositoryCustom.createPartByCarId(carId, part);
		
		return new ResponseEntity<>(part, HttpStatus.CREATED);
	}
	
	@PutMapping("/cars/parts/{id}/{name}")
	public ResponseEntity<Part> updatePart(@PathVariable("id") String carId, 
			@PathVariable("name") String partName,
			@Valid @RequestBody Part part) {
		Car carData = carRepository.findOneByCarId(carId, partName);
		
		if (carData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Part partUdated = partRespositoryCustom.updatePartByCarId(carId, part);
		
		return new ResponseEntity<>(partUdated, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/cars/parts/{id}/{name}")
	public void getAllCars(@PathVariable("id") String carId, 
			@PathVariable("name") String partName) {
		partRespositoryCustom.deletePartByCarId(carId, partName);
	}
	
}
