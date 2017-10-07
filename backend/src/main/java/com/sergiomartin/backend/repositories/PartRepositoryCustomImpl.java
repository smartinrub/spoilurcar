package com.sergiomartin.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.sergiomartin.backend.models.Car;
import com.sergiomartin.backend.models.Part;

@Repository
public class PartRepositoryCustomImpl implements PartRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public void createPartByCarId(String carId, Part part) {
		Query query = Query.query(Criteria.where("id").is(carId));
		
		Update update = new Update()
				.push("parts", part);
		
		mongoTemplate.updateMulti(query, update, Car.class);
		
	}
	
	@Override
	public Part updatePartByCarId(String carId, Part part) {
		Query query = Query.query(Criteria.where("id").is(carId));
		
		//TODO: make it more simple, everything in one update
		Update update = new Update()
				.pull("parts", new BasicDBObject("name", part.getName()));
		mongoTemplate.updateFirst(query, update, Car.class);
		
		update = new Update()
				.addToSet("parts", part);
		mongoTemplate.updateFirst(query, update, Car.class);
		return part;
	}
	
	@Override
	public void deletePartByCarId(String carId, String partName) {
		Query query = Query.query(Criteria.where("id").is(carId));
		
		Update update = new Update()
				.pull("parts", new BasicDBObject("name", partName));
		
		mongoTemplate.updateMulti(query, update, Car.class);
	}

}
