package com.sergiomartin.spoilurcar.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sergiomartin.spoilurcar.models.Car;
import com.sergiomartin.spoilurcar.repositories.CarRepository;

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
	public void createCar(@Valid @RequestBody Car car) {
		carRepository.save(car);
	}
	
	@GetMapping(value = "/cars/{plate}")
	public ResponseEntity<Car> getCarByPlate(
			@PathVariable("plate") String plate) {
		Car car = carRepository.findOne(plate);
		
		if (car == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(car, HttpStatus.OK);
		}
	}
	
	@PutMapping(value = "/cars/{plate}")
	public ResponseEntity<Car> updateCar(
			@PathVariable("plate") String plate, 
			@Valid @RequestBody Car car) {
		Car carData = carRepository.findOne(plate);
		
		if (carData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		carData.setModel(car.getModel());
		carData.setYear(car.getYear());
		carData.setColor(car.getColor());
		
		Car updatedCar = carRepository.save(carData);
		
		return new ResponseEntity<>(updatedCar, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/cars/{plate}")
	public void deleteCar(@PathVariable("plate") String plate) {
		carRepository.delete(plate);
	}
}
