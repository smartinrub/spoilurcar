package com.sergiomartin.spoilurcar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sergiomartin.spoilurcar.models.Car;

public interface CarRepository extends MongoRepository<Car, String> {
	
    @Query("{$and:[{'_id': '?0'}, {'parts': {$elemMatch: {'name': '?1'}}}]}")
    Car findOneByCarId(String carId, String partName);
	
}
