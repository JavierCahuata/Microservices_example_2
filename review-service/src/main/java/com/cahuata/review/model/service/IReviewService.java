package com.cahuata.review.model.service;

import java.util.List;
import java.util.Optional;

import com.cahuata.review.model.entity.Review;

public interface IReviewService {
	
	public List<Review> findAll();
	
	public Review save(Review review);
	
	public Optional<Review> findById(Long id);
	
	public void delete(Long id);

	public List<Review> findByDoctorId(Long doctorId);
	
	public List<Review> findByPatientDni(String patientDni);

	
}
