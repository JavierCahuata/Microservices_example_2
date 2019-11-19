package com.cahuata.review.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="reviews")
public class Review implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long doctorId;	
	private String review_des;
	@Size(min=8, max=12) 
	private String patientDni;
	@NotNull @Min(1) @Max(5)
	private Double rate;
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	



	public String getPatientDni() {
		return patientDni;
	}


	public void setPatientDni(String patientDni) {
		this.patientDni = patientDni;
	}


	public Review(Long doctorId, String review_des, String patientDni, Double rate, Date createAt) {
		//super();
		this.doctorId = doctorId;
		this.review_des = review_des;
		this.patientDni = patientDni;
		this.rate = rate;
		this.createAt = createAt;
	}


	public Long getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}


	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getReview_des() {
		return review_des;
	}

	public void setReview_des(String review_des) {
		this.review_des = review_des;
	}

	public @NotNull @Min(1) @Max(5) Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
