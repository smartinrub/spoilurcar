package com.sergiomartin.spoilurcar.models;

import java.util.List;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "cars")
@JsonIgnoreProperties(value = {"CreateAt"}, allowGetters = true)
public class Car {
	@Id
	@NotBlank
	@Size(max = 8, min = 6)
	@Field("_id")
	private String id;
	@Size(max = 100)
	private String model;
	private Integer year;
	private String color;
	private List<Part> parts;
	
	
	public Car() {
		super();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	

	public List<Part> getParts() {
		return parts;
	}


	public void setParts(List<Part> parts) {
		this.parts = parts;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", year=" + year
				+ ", color=" + color + "]";
	}
	
}
