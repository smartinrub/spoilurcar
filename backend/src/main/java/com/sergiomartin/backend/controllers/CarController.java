package com.sergiomartin.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiomartin.backend.models.Car;
import com.sergiomartin.backend.repositories.CarRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CarController {

	@Autowired
	CarRepository carRepository;
	
	@GetMapping("/cars")
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
		carRepository.save(car);
		return new ResponseEntity<>(car, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/cars/{id}")
	public ResponseEntity<Car> getCarByid(
			@PathVariable("id") String id) {
		Car car = carRepository.findOne(id);
		
		if (car == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(car, HttpStatus.OK);
		}
	}
	
	@PutMapping(value = "/cars/{id}")
	public ResponseEntity<Car> updateCar(
			@PathVariable("id") String id, 
			@Valid @RequestBody Car car) {
		Car carData = carRepository.findOne(id);
		
		if (carData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
		Car updatedCar = carRepository.save(car);
		
		return new ResponseEntity<>(updatedCar, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/cars/{id}")
	public void deleteCar(@PathVariable("id") String id) {
		carRepository.delete(id);
	}
}
