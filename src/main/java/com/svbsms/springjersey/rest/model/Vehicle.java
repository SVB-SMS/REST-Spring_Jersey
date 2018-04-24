package com.svbsms.springjersey.rest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "vehicle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle {
	
	@XmlElement(name="id")
	@NotNull(message = "Id cannot be empty")
	private int id;
	@XmlElement(name="year")
	@Size(min=1950, max=2050)
	private int year;
	@XmlElement(name="make")
	@NotNull(message = "Make should not be left blank")
	private String make;
	@XmlElement(name="model")
	@NotNull(message = "Model should not be left blank")
	private String model;
	
	public Vehicle() {
	}
	public Vehicle(int id, int year, String make, String model) {
		super();
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", year=" + year + ", make=" + make + ", model=" + model + "]";
	}
	
	

}
