package com.cahuata.doctor.model.entity;

import java.util.Date;

public class Review {
	private Long id;	
	private String review_des;
	private String patientDni;
	private Double rate;
	private Date createAt;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	public Review(String review_des, String patientDni, Double rate, Date createAt) {
		this.review_des = review_des;
		this.patientDni = patientDni;
		this.rate = rate;
		this.createAt = createAt;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getReview_des() {
		return review_des;
	}


	public void setReview_des(String review_des) {
		this.review_des = review_des;
	}


	public String getPatientDni() {
		return patientDni;
	}


	public void setPatientDni(String patientDni) {
		this.patientDni = patientDni;
	}


	public Double getRate() {
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


	@Override
	public String toString() {
		return "Review [id=" + id + ", review_des=" + review_des + ", patientDni=" + patientDni + ", rate=" + rate
				+ ", createAt=" + createAt + "]";
	}
	
	
}
