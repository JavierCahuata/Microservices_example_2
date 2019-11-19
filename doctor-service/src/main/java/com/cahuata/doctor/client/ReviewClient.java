package com.cahuata.doctor.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cahuata.doctor.model.entity.Review;

@FeignClient(name = "review-service", fallback = ReviewClientFallback.class)
public interface ReviewClient {
	
	@GetMapping("/findByDoctorId/{doctorId}")
	public List<Review> findByDoctorId(@PathVariable("doctorId") Long doctorId);
}
