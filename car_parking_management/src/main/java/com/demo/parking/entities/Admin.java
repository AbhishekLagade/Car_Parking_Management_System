package com.demo.parking.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin") 
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Admin_Id", length = 10)
	private String Admin_Id;
	
	@Column(name = "Admin_RoleID", length = 25)
	private String ParkingFees_Type;
	
	@Column(name = "Per_Module", length = 25)
	private String Per_Module;
	
	@Column(name = "Date")
	private Date date;
	
	
	public String getAdmin_Id() {
		return Admin_Id;
	}
	public void setAdmin_Id(String admin_Id) {
		Admin_Id = admin_Id;
	}
	public String getParkingFees_Type() {
		return ParkingFees_Type;
	}
	public void setParkingFees_Type(String parkingFees_Type) {
		ParkingFees_Type = parkingFees_Type;
	}
	public String getPer_Module() {
		return Per_Module;
	}
	public void setPer_Module(String per_Module) {
		Per_Module = per_Module;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Admin [Admin_Id=" + Admin_Id + ", ParkingFees_Type=" + ParkingFees_Type + ", Per_Module=" + Per_Module
				+ ", date=" + date + "]";
	}
	public Admin(String parkingFees_Type, String per_Module, Date date) {
		super();
		//Admin_Id = admin_Id;
		ParkingFees_Type = parkingFees_Type;
		Per_Module = per_Module;
		this.date = date;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}