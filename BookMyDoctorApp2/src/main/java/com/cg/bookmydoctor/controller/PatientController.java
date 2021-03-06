package com.cg.bookmydoctor.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidatePatientException;
import com.cg.bookmydoctor.serviceimpl.PatientServiceImpl;

/**
 * @author PriyaJoshi
 *         REST Controller with different HTTP methods 
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "patient"       
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientService;

	
	@PostMapping("/addpatient")
	public Patient addPatient(@RequestBody Patient bean) throws PatientException, ValidatePatientException {
		return patientService.addPatient(bean);
	}

	
	@PutMapping("/updatepatient")
	public Patient editPatientProfile(@RequestBody Patient bean) throws PatientException, ValidatePatientException {
		return patientService.editPatientProfile(bean);
	}
	
	
	@DeleteMapping("/removepatient")
	public Patient removePatientDetails(@RequestBody Patient bean) throws PatientException {
		return patientService.removePatientDetails(bean);
	}
	
	
	@GetMapping("/getpatient")
	public Patient getPatient(@RequestParam("patientId") Patient patient) throws PatientException {
		return patientService.getPatient(patient);
	}

	
	@GetMapping("/getallpatients")
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}
	
}