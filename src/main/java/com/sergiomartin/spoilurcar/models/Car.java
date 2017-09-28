package com.sergiomartin.spoilurcar.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "car")
@JsonIgnoreProperties(value = {"CreateAt"}, allowGetters = true)
public class Car {
	@Id
	private String id;
	@NotBlank
	@Size(max = 8, min = 6)
	@Indexed(unique = true)
	private String plate;
	@Size(max = 100)
	private String model;
	@Size(max = 4)
	private int year;
	private String color;
	
	
	public Car() {
		super();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", plate=" + plate + ", model=" + model + ", year=" + year + ", color=" + color + "]";
	}
	
	
}
