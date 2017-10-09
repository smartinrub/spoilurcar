package com.sergiomartin.backend.repositories;

import com.sergiomartin.backend.models.Part;


/**
 * This custom repository make queries to make operations with parts
 * 
 * @author Sergio Martin Rubio
 * @date 09-Oct-2017
 */
public interface PartRepositoryCustom {
	
	public void createPartByCarId(String carId, Part part);
	
	public Part updatePartByCarId(String carId, Part part);
	
	public void deletePartByCarId(String carId, String partName);
	
}
