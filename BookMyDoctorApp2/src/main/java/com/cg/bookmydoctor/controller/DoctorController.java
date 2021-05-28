package com.cg.bookmydoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.serviceimpl.DoctorServiceImpl;


@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorServiceImpl doctorService;

	//working
	@PostMapping("/adddoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}

	//working
	@GetMapping("/getalldoctors")
	public List<Doctor> getDoctorList() {
		return doctorService.getDoctorList();
	}

	//working
	@DeleteMapping("/removedoctor")
	public Doctor removeDoctor(@RequestBody Doctor doctor) {
		return doctorService.removeDoctor(doctor);
	}

	//working
	@PutMapping("/updatedoctor")
	public Doctor updateDoctorProfile(@RequestBody Doctor doctor) {
		return doctorService.updateDoctorProfile(doctor);
	}
	
	//working
	@GetMapping("/getdoctor/{doctorId}")
	public Doctor getDoctor(@PathVariable("doctorId") Doctor doc) {
		return doctorService.getDoctor(doc);
	}
	
	//working
	@GetMapping("/getdoctor/{speciality}")
	public List<Doctor> getDoctorList(@PathVariable("speciality") String speciality) {
		return doctorService.getDoctorList(speciality);
	}
	
	//working
	@PostMapping("/addavailability")
	public boolean addAvailability(@RequestBody AvailabilityDates bean) {
		return doctorService.addAvailability(bean);
	}
	
    //working
	@PostMapping("/updateavailability")
	public boolean updateAvailability(@RequestBody AvailabilityDates bean) {
		return doctorService.updateAvailability(bean);
	}
	

	
}