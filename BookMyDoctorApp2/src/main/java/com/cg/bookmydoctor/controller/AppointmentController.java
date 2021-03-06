package com.cg.bookmydoctor.controller;

import java.time.LocalDate;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.exception.ValidateAppointmentException;
import com.cg.bookmydoctor.serviceimpl.AppointmentServiceImpl;

/**
 * @author Ruchitha 
 *         REST Controller with different HTTP methods 
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "appointment"       
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentServiceImpl appointmentService;

	
	@GetMapping("/getallappointments")
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}
	
	
	@PostMapping("/addappointment")
	public Appointment addAppointment(@RequestBody Appointment app) throws AppointmentException, ValidateAppointmentException{
		return appointmentService.addAppointment(app);
	}
	
	
	@GetMapping("/getappointment/{appointmentId}")
	public Appointment getAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentException {
		return appointmentService.getAppointment(appointmentId);
	}


	@DeleteMapping("/deleteappointment/{id}")
	public boolean deleteAppointment(@PathVariable("id") int appointmentId) throws AppointmentException {
		return appointmentService.deleteAppointment(appointmentId);
	}
	
	@PutMapping("/updateappointment")
	public boolean updateAppointment(@RequestBody Appointment bean) throws ValidateAppointmentException {
		return appointmentService.updateAppointment(bean);
	}
	
	
	@GetMapping("/datebasedappointments")
	public List<Appointment> getAppointments(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	@RequestParam("appointmentDate") LocalDate date){
		return appointmentService.getAppointments(date);
	}
	
}