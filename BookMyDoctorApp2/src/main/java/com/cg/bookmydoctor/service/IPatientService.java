package com.cg.bookmydoctor.service;

import java.time.LocalDate;
import java.util.List;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidatePatientException;

public interface IPatientService {

	Patient addPatient(Patient bean) throws PatientException, ValidatePatientException;
	Patient editPatientProfile(Patient bean) throws PatientException, ValidatePatientException;
	Patient removePatientDetails(Patient bean) throws PatientException;
	Patient getPatient(Patient patient) throws PatientException;
	List<Patient> getAllPatient() throws PatientException;
	List<Patient> getPatientListByDoctor(Doctor doctor) throws PatientException;
	List<Patient> getPatientListByDate(LocalDate appdate) throws PatientException;
	
	
}
