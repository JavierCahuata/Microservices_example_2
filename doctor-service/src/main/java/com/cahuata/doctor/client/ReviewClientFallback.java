package com.cahuata.doctor.client;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cahuata.doctor.model.entity.Review;

@Component
public class ReviewClientFallback implements ReviewClient{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewClientFallback.class);
	@Override
	public List<Review> findByDoctorId(Long doctorId) {
		// TODO Auto-generated method stub
		LOGGER.info("Review service down");
		return Collections.emptyList();
	}

}
