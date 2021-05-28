package com.cg.bookmydoctor.dao;


import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Patient;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientDao  extends JpaRepository<Patient, Integer> {
	
	//List<Appointment> findAllByAppointmentDate(LocalDate date);
	

}
