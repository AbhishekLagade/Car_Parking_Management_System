package com.demo.parking.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingFees {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ParkingFees_Id", length = 10)
	private String ParkingFees_Id;
	@Column(name = "ParkingFees_Type", length = 25)
	private String ParkingFees_Type;
	@Column(name = "ParkingFees_Description", length = 25)
	private String ParkingFees_Description;
	@Column(name = "parking_fees_date")
	private Date parkingFeesDate;
	@Column(name = "parking_fees_amount")
	private double parkingFeesAmount;
	public String getParkingFees_Id() {
		return ParkingFees_Id;
	}
	public void setParkingFees_Id(String parkingFees_Id) {
		ParkingFees_Id = parkingFees_Id;
	}
	public String getParkingFees_Type() {
		return ParkingFees_Type;
	}
	public void setParkingFees_Type(String parkingFees_Type) {
		ParkingFees_Type = parkingFees_Type;
	}
	public String getParkingFees_Description() {
		return ParkingFees_Description;
	}
	public void setParkingFees_Description(String parkingFees_Description) {
		ParkingFees_Description = parkingFees_Description;
	}
	public Date getParkingFeesDate() {
		return parkingFeesDate;
	}
	public void setParkingFeesDate(Date parkingFeesDate) {
		this.parkingFeesDate = parkingFeesDate;
	}
	public double getParkingFeesAmount() {
		return parkingFeesAmount;
	}
	public void setParkingFeesAmount(double parkingFeesAmount) {
		this.parkingFeesAmount = parkingFeesAmount;
	}
	@Override
	public String toString() {
		return "ParkingFees [ParkingFees_Id=" + ParkingFees_Id + ", ParkingFees_Type=" + ParkingFees_Type
				+ ", ParkingFees_Description=" + ParkingFees_Description + ", parkingFeesDate=" + parkingFeesDate
				+ ", parkingFeesAmount=" + parkingFeesAmount + "]";
	}
	public ParkingFees( String parkingFees_Type, String parkingFees_Description,
			Date parkingFeesDate, double parkingFeesAmount) {
		super();
		// ParkingFees_Id = parkingFees_Id;
		ParkingFees_Type = parkingFees_Type;
		ParkingFees_Description = parkingFees_Description;
		this.parkingFeesDate = parkingFeesDate;
		this.parkingFeesAmount = parkingFeesAmount;
	}
	public ParkingFees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
