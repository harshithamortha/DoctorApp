package com.cg.bookmydoctor.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.service.AppointmentServiceImpl;


@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentServiceImpl AppointmentService;

	//working
	@GetMapping("/getAllAppointments")
	public List<Appointment> getAllAppointments() {
		return AppointmentService.getAllAppointments();
	}
	
	//working
	@PostMapping("/addAppointment")
	@ExceptionHandler(AppointmentException.class)
	public Appointment addAppointment(@RequestBody Appointment app) {
		return AppointmentService.addAppointment(app);
	}
	
	//working
	@GetMapping("/getAppointment/{AppointmentId}")
	@ExceptionHandler(AppointmentException.class)
	public Appointment getAppointment(@PathVariable("AppointmentId") int AppointmentId) {
		return AppointmentService.getAppointment(AppointmentId);
	}

	
	//working
	@DeleteMapping("/deleteAppointment/{id}")
	@ExceptionHandler(AppointmentException.class)
	public boolean deleteAppointment(@PathVariable("id") int AppointmentId) {
		return AppointmentService.deleteAppointment(AppointmentId);
	}
	
	
	//working
	@PutMapping("/updateAppointment")
	@ExceptionHandler(AppointmentException.class)
	public boolean updateAppointment(@RequestBody Appointment bean) {
		return AppointmentService.updateAppointment(bean);
	}
	
	
	@GetMapping("/DoctorBasedAppointments/{id}")
	public List<Appointment> getAppointments(@PathVariable("id")Doctor doc) {
		return AppointmentService.getAppointments(doc);
	}
	
	@GetMapping("/DateBasedAppointments")
	public List<Appointment> getAppointments(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return AppointmentService.getAppointments(date);
	}
	
}