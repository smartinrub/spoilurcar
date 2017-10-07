package com.sergiomartin.backend.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class Part {
	
	private String name;
	private String date;
	@Field("lastdate")
	private String lastDate;
	private Integer kms;
	@Field("lastkms")
	private Integer lastKms;
	@Field("nextkms")
	private Integer nextKms;
	private String details;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public Integer getKms() {
		return kms;
	}
	public void setKms(Integer kms) {
		this.kms = kms;
	}
	public Integer getLastKms() {
		return lastKms;
	}
	public void setLastKms(Integer lastKms) {
		this.lastKms = lastKms;
	}
	public Integer getNextKms() {
		return nextKms;
	}
	public void setNextKms(Integer nextKms) {
		this.nextKms = nextKms;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}