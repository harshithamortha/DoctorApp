package com.cg.bookmydoctor.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.service.IPatientService;
import com.cg.bookmydoctor.dao.IPatientDao;
import com.cg.bookmydoctor.dao.IAppointmentDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; 
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
	private IPatientDao patientDao;
	@Autowired
	private IAppointmentDao appointmentDao;
	
	Appointment a;

	@Override
	public Patient addPatient(Patient bean) throws PatientException {
		if(bean == null) {
			throw new PatientException("Passed object can't be null");
		} else {
			return patientDao.save(bean);
		}
	}

	@Override
	public Patient editPatientProfile(Patient bean) throws PatientException{
		Optional<Patient> patientDb = patientDao.findById(bean.getPatientId());
		if (patientDb.isPresent()) {
			patientDao.save(bean);
		} 
		else
			throw new PatientException("Patient with ID: " + bean.getPatientId() + "does not exists");
		return bean;

	} 
		
	@Override
	public Patient removePatientDetails(Patient bean) throws PatientException{
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
	public Patient getPatient(Patient patient) throws PatientException{
		Optional<Patient> patientDb = this.patientDao.findById(patient.getPatientId());
		if(patientDb.isPresent()) {
			return patientDb.get();
		}
		else {
			throw new PatientException("Record not found with id : " + patient.getPatientId());
		}
	}
	
	@Override
	public List<Patient> getAllPatient() throws PatientException{
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