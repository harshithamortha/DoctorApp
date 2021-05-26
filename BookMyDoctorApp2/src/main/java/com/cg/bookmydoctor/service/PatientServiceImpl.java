package com.cg.bookmydoctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.dao.IPatientDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; 
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
	private IPatientDao patientDao;
	
	Appointment a;

	@Override
	//working
	public Patient addPatient(Patient bean) {
		//Optional<Doctor> findById = docDao.findById(dr.getDoctorId());
		if(bean == null) {
			throw new PatientException("Passed object can't be null");
		} else {
			return patientDao.save(bean);
		}
	}

	@Override
	//working
	public Patient editPatientProfile(Patient bean) {
		Optional<Patient> patientDb = patientDao.findById(bean.getPatientId());
		if (patientDb.isPresent()) {
			patientDao.save(bean);
		} 
		else
			throw new PatientException("Patient with ID: " + bean.getPatientId() + "does not exists");
		return bean;

	} 
		
	@Override
	//working
	public Patient removePatientDetails(Patient bean) {
		Patient Patient1 = bean;
		Optional<Patient> docdb = patientDao.findById(bean.getPatientId());
		if(docdb.isPresent()) {
			patientDao.delete(bean);	
		} else {
			throw new PatientException("Record not Found");
		}
		return Patient1;
	}
	
	@Override
	//working
	public Patient getPatient(Patient patient) {
		Optional<Patient> patientDb = this.patientDao.findById(patient.getPatientId());
		if(patientDb.isPresent()) {
			return patientDb.get();
		}
		else {
			throw new PatientException("Record not found with id : " + patient.getPatientId());
		}
	}
	
	@Override
	//working
	public List<Patient> getAllPatient(){
		Iterable<Patient> result = patientDao.findAll();
		List<Patient> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}
	
	@Override
	public List<Patient> getPatientListByDoctor(Doctor doctor){
		String docname = doctor.getDoctorName();
		List<Patient> pat = new ArrayList<>();
		if(a.getDoctor().getDoctorName().equals(docname)) {
			pat.add(a.getPatient());
		}
		return pat;
	}
	
	@Override
	public List<Patient> getPatientListByDate(LocalDate appdate){
		List<Patient> p1 = new ArrayList<>();
		LocalDate localDate = a.getAppointmentDate();
		if(localDate == appdate) {
			p1.add(a.getPatient());
		}
		return p1;
	}
}