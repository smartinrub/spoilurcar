package com.sergiomartin.spoilurcar.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.sergiomartin.spoilurcar.models.Car;
import com.sergiomartin.spoilurcar.models.Part;

@Repository
public class PartRepositoryImpl implements PartRepository {

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
	public void deletePartByCarId(String carId, String partName) {
		Query query = Query.query(Criteria.where("id").is(carId));
		
		Update update = new Update()
				.pull("parts", new BasicDBObject("name", partName));
		
		mongoTemplate.updateMulti(query, update, Car.class);
	}

}
