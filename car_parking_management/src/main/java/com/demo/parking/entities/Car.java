package com.demo.parking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	
	@Column(name = "Car_number", length = 10)
	private String Car_number;
	@Column(name = "Car_Type", length = 25)
	private String Car_Type;
	@Column(name = "Car_Description", length = 25)
	private String Car_Description;
	@Column(name = "Car_Category", length = 25)
	private String Car_Category;
	public String getCar_number() {
		return Car_number;
	}
	public void setCar_number(String car_number) {
		Car_number = car_number;
	}
	public String getCar_Type() {
		return Car_Type;
	}
	public void setCar_Type(String car_Type) {
		Car_Type = car_Type;
	}
	public String getCar_Description() {
		return Car_Description;
	}
	public void setCar_Description(String car_Description) {
		Car_Description = car_Description;
	}
	public String getCar_Category() {
		return Car_Category;
	}
	public void setCar_Category(String car_Category) {
		Car_Category = car_Category;
	}
	@Override
	public String toString() {
		return "Car [Car_number=" + Car_number + ", Car_Type=" + Car_Type + ", Car_Description=" + Car_Description
				+ ", Car_Category=" + Car_Category + "]";
	}
	public Car(String car_number, String car_Type, String car_Description, String car_Category) {
		super();
		Car_number = car_number;
		Car_Type = car_Type;
		Car_Description = car_Description;
		Car_Category = car_Category;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
