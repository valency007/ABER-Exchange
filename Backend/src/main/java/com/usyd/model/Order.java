package com.usyd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class Order {
	
	@Id
	@GeneratedValue
	private Integer id;	
	private String name;
	private String email;
	private Integer cnumber;
	private String s_address;
	private String d_address;
	private String notes;
	private String rider;
	private Integer isDonation;
	private Integer status;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRider() {
		return rider;
	}
	public void setRider(String rider) {
		this.rider = rider;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getCnumber() {
		return cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}
	
	public String getS_address() {
		return s_address;
	}
	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	
	public String getD_address() {
		return d_address;
	}
	public void setD_address(String d_address) {
		this.d_address = d_address;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getIsDonation() {
		return isDonation;
	}
	public void setIsDonation(Integer isDonation) {
		this.isDonation = isDonation;
	}
	
	

}
