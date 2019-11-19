package com.cahuata.doctor.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cahuata.doctor.model.dao.IDoctorDao;
import com.cahuata.doctor.model.entity.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService{
	@Autowired
	private IDoctorDao doctordao;

	
	@Override
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		return (List<Doctor>) doctordao.findAll();
	}

	@Override
	public Doctor save(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctordao.save(doctor);
	}

	@Override
	public Doctor findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Doctor> o = doctordao.findById(id);
		
		if (o.isPresent())
			return o.get();
		else
			return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		doctordao.deleteById(id);
	}

	@Override
	public List<Doctor> findByAddressAndSpecialty(String city, String specialty) {
		// TODO Auto-generated method stub
		return doctordao.findByAddressAndSpecialty(city, specialty);
	}

}
