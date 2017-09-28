package com.sergiomartin.spoilurcar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sergiomartin.spoilurcar.models.Car;

public interface CarRepository extends MongoRepository<Car, String> {

}
