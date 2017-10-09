package com.sergiomartin.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sergiomartin.backend.models.Car;


/**
 *  Repository with all default methods to retrieve data
 *	from mongoDB
 *
 * @author Sergio Martin Rubio
 * @date 09-Oct-2017
 */
public interface CarRepository extends MongoRepository<Car, String> {
	
    @Query("{$and:[{'_id': '?0'}, {'parts': {$elemMatch: {'name': '?1'}}}]}")
    Car findOneByCarId(String carId, String partName);
	
}
