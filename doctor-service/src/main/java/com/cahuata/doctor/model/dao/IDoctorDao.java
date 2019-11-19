package com.cahuata.doctor.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cahuata.doctor.model.entity.Doctor;

@Repository
public interface IDoctorDao extends CrudRepository<Doctor, Long>{

	List<Doctor> findByAddressAndSpecialty(String city, String specialty);

}
