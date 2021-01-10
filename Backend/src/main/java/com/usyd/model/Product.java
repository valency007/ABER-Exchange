package com.usyd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue
	private Integer uid;	
	private String description;
	private String category;
	@Column(name="IsDonation")
	private Integer isDonation;
	private String title;
	private Double price;
	@Column(name="Image")
	private String image;
	
	public Integer getUid() {
		return uid;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}
	
	public Integer getIsDonation() {
		return isDonation;
	}

	public String getImage() {
		return image;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Double getPrice() {
		return price;
	}

	

}
