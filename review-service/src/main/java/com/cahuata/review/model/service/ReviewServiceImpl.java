package com.cahuata.review.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cahuata.review.model.dao.IReviewDao;
import com.cahuata.review.model.entity.Review;

@Service
public class ReviewServiceImpl implements IReviewService{
	@Autowired
	private IReviewDao reviewdao;
	
	
	@Override
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		return (List<Review>) reviewdao.findAll();
	}

	@Override
	public Review save(Review review) {
		// TODO Auto-generated method stub
		return reviewdao.save(review);
	}

	@Override
	public Optional<Review> findById(Long id) {
		// TODO Auto-generated method stub
		return reviewdao.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		reviewdao.deleteById(id);
	}

	@Override
	public List<Review> findByDoctorId(Long doctorId) {
		// TODO Auto-generated method stub
		return reviewdao.findByDoctorId(doctorId);
	}

	@Override
	public List<Review> findByPatientDni(String patientDni) {
		// TODO Auto-generated method stub
		return reviewdao.findByPatientDni(patientDni);
	}

}
