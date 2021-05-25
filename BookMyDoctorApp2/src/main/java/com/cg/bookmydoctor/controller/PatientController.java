package com.cg.bookmydoctor.controller;

import java.time.LocalDate;
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

import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.service.PatientServiceImpl;


@RestController
@RequestMapping("/Patients")

public class PatientController {
	
	@Autowired
	PatientServiceImpl PatientService;

	//working
	@PostMapping("/addPatient")
	@ExceptionHandler(PatientException.class)
	public Patient addPatient(@RequestBody Patient bean) {
		return PatientService.addPatient(bean);
	}

	//working
	@PutMapping("/updatePatient")
	@ExceptionHandler(PatientException.class)
	public Patient editPatientProfile(@RequestBody Patient bean) {
		return PatientService.editPatientProfile(bean);
	}
	
	//working
	@DeleteMapping("/removePatientDetails")
	@ExceptionHandler(PatientException.class)
	public Patient removePatientDetails(@RequestBody Patient bean) {
		return PatientService.removePatientDetails(bean);
	}
	
	//working
	@GetMapping("/getPatient/{patientId}")
	@ExceptionHandler(PatientException.class)
	public Patient getPatient(@PathVariable("patientId") Patient Patient) {
		return PatientService.getPatient(Patient);
	}

	//working
	@GetMapping("/allPatient")
	public List<Patient> getAllPatient() {
		return PatientService.getAllPatient();
	}
	
	@GetMapping("/allPatientByDoctor/{doctorName}")
	public List<Patient> getPatientListByDoctor(@PathVariable("doctorName") Doctor doc) {
		return PatientService.getPatientListByDoctor(doc);
	}
	
	
	@GetMapping("/allPatienByDate")
	public List<Patient> getPatientListByDate(LocalDate appdate) {
		return PatientService.getPatientListByDate(appdate);
	}
}