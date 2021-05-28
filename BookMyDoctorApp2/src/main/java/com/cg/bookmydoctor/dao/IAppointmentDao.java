package com.cg.bookmydoctor.dao;


import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Patient;


public interface IAppointmentDao extends JpaRepository<Appointment, Integer>  {
	
	List<Appointment> findAllByAppointmentDate(LocalDate date);
	
}
