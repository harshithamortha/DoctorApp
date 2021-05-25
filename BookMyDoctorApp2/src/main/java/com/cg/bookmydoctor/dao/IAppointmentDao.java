package com.cg.bookmydoctor.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookmydoctor.dto.Appointment;


public interface IAppointmentDao extends JpaRepository<Appointment, Integer>  {
		

}
