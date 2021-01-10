package com.usyd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_information")
public class User {
	
	@Id
	@GeneratedValue
	private Integer uid;	
	private String fname;
	private String lname;
	private String email;
	private String password;
	private Integer contact_number;
	private Integer credit;
	
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getContact_number() {
		return contact_number;
	}
	public void setContact_number(Integer contact_number) {
		this.contact_number = contact_number;
	}
	
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	

}
