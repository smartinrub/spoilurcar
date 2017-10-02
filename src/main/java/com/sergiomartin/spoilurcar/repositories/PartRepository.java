package com.sergiomartin.spoilurcar.repositories;

public interface PartRepository {
	
	public void deletePartByCarId(String carId, String partName);
	
}
