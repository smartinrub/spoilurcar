package com.sergiomartin.spoilurcar.repositories;

import com.sergiomartin.spoilurcar.models.Part;

public interface PartRepositoryCustom {
	
	public void createPartByCarId(String carId, Part part);
	
	public Part updatePartByCarId(String carId, Part part);
	
	public void deletePartByCarId(String carId, String partName);
	
}
