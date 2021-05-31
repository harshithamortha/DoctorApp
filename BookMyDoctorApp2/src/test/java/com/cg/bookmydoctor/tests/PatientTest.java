package com.cg.bookmydoctor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bookmydoctor.BookMyDoctorApp2ApplicationTests;
import com.cg.bookmydoctor.dao.IPatientDao;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidatePatientException;
import com.cg.bookmydoctor.service.IPatientService;

@SpringBootTest
public class PatientTest extends BookMyDoctorApp2ApplicationTests {
	@Autowired
	private IPatientService patientservice;
	@Autowired
	private IPatientDao patientDao;
	
	
	@Test
	void testpatientServiceImpl() {
		assertTrue(patientservice instanceof IPatientService);
	}
	
	@Test
	public void testAddPatient() throws PatientException, ValidatePatientException {
		Patient patient = new Patient(1,"Priya","8918890652","priya@gmail.com","Priya@234","A+","Female",23,"Pune");
		patient = patientservice.addPatient(patient);
		assertEquals(patient.getPatientId(),1);
		
		Patient patient1 = new Patient(2,"Soumya","7829901763","soumya@gmail.com","Soumya@234","O+","Female",28,"Hyderabad");
		patient1 = patientservice.addPatient(patient1);
		assertEquals(patient1.getPatientId(),2);
	}
	
	
	@Test
	public void testEditPatient() throws PatientException, ValidatePatientException {
		Patient patient = new Patient(1,"Divya","8918890635","priya@gmail.com","Priya@234","A+","Female",23,"Pune");
		patient = patientservice.editPatientProfile(patient);
		assertEquals(patient.getPatientName(),"Divya"); 
		
	}
	
	@Test
	public void testRemovePatientDetails() throws PatientException{
		Patient patient = patientDao.findById(2).get();
		Patient removepatient = patientservice.removePatientDetails(patient);
	    assertEquals(removepatient,patient);
	}
	
	@Test 
	void testGetAllPatient() throws PatientException {
		List<Patient> pat = patientservice.getAllPatient(); 
		assertNotNull(pat);
	}
}