package com.sergiomartin.spoilurcar.repositories;

import com.sergiomartin.spoilurcar.models.Part;

public interface PartRepository {
	
	public void createPartByCarId(String carId, Part part);
	
	public void deletePartByCarId(String carId, String partName);
	
}
