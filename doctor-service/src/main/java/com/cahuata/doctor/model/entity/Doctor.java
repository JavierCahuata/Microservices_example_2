package com.cahuata.doctor.model.entity;

import java.io.Serializable;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="doctors")
public class Doctor implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	private String name;
	private String address;
	private String specialty;
	@Transient
	private Double rating;
	//@Transient
	//private List<Review> reviews;
	
	
	
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}




	public Doctor(String name, String address, String specialty) {
		super();
		this.name = name;
		this.address = address;
		this.specialty = specialty;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getSpecialty() {
		return specialty;
	}




	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Double getRating() {
		return rating;
	}




	public void setRating(Double rating) {
		this.rating = rating;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
