package com.cahuata.review.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cahuata.review.model.entity.Review;

@Repository
public interface IReviewDao extends CrudRepository<Review, Long>{
	
	public List<Review> findByDoctorId(Long doctorId);
	public List<Review> findByPatientDni(String patientDni);
}
