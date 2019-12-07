package com.cahuata.doctor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cahuata.doctor.client.ReviewClient;
import com.cahuata.doctor.model.entity.Doctor;
import com.cahuata.doctor.model.entity.Review;
import com.cahuata.doctor.model.service.IDoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = { "http://localhost:4200", "*" })
public class DoctorController {
private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	IDoctorService repository;
	@Autowired
	ReviewClient reviewClient;

    @Value("${server.port}")
    private String serverPort;
	
	//@PostMapping("/doctor/add")
	@PostMapping("/add")
	public Doctor add(@RequestBody Doctor doctor) {
		LOGGER.info("Doctor add: {}", doctor);
		return repository.save(doctor);
	}
	
	//@GetMapping("/doctor/find/{id}")
	@GetMapping("/find/{id}")
	public Doctor findById(@PathVariable("id") Long id) {
		LOGGER.info("Doctor find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/list")
	public List<Doctor> findAll() {
		LOGGER.info("Doctor list");
		return repository.findAll();
	}
	
	@GetMapping("/findByCityAndSpecialty/{city}/{specialty}")
	public List<Doctor> findByCityAndSpecialty(@PathVariable("city") String city, @PathVariable("specialty") String specialty) {
		LOGGER.info("Doctor findBy: city and specialty={}", city, specialty);
		return repository.findByAddressAndSpecialty(city, specialty);
	}
	
	@GetMapping("/findByDoctorId/{id}/with-rating")
	public Doctor findByDoctorIdWithRating(@PathVariable("id") Long id) {
		LOGGER.info("Doctor find: id={}", id);
		Doctor doctor = repository.findById(id);
		Double sum=(double) 0;
		int cont = 0;
		for(Review review : reviewClient.findByDoctorId(id)){
  			sum += review.getRate();
  			cont +=1; 
		}
		try {
			doctor.setRating(sum/cont);	
		}catch(Exception e){
			LOGGER.error("division entre cero");
		}
			
		return doctor;
	}
	
	@GetMapping("/port")
	public String showPort() {
		return serverPort;
	}
}
