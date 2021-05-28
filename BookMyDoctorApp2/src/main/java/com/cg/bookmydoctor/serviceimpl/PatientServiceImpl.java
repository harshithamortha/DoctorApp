package com.cg.bookmydoctor.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.service.IPatientService;
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
	public Patient addPatient(Patient bean) throws PatientException {
		Optional<Patient> patientdb= patientDao.findById(bean.getPatientId());
		if(patientdb.isPresent()) {
			throw new PatientException("Patient already exists with ID : " +bean.getPatientId());
		}
		 else {
			return patientDao.save(bean);
		}
	}

	@Override
	public Patient editPatientProfile(Patient bean) throws PatientException{
		Optional<Patient> patientDb = patientDao.findById(bean.getPatientId());
		if (!patientDb.isPresent()) {
			throw new PatientException("Patient doesn't exist with ID : " +bean.getPatientId());
		} 
		else {
			return patientDao.save(bean);
		}
	} 
		
	@Override
	public Patient removePatientDetails(Patient bean) throws PatientException{
		Patient Patient1 = bean;
		Optional<Patient> patientDb = patientDao.findById(bean.getPatientId());
		if (!patientDb.isPresent()) {
			throw new PatientException("Patient with id : " +bean.getPatientId() +"doesn't exist to delete");
		} 
		else {
			patientDao.deleteById(bean.getPatientId());	
		}
		return Patient1;
	}
	
	@Override
	public Patient getPatient(Patient patient) throws PatientException{
		Optional<Patient> patientDb = patientDao.findById(patient.getPatientId());
		if(patientDb.isPresent()) {
			return patientDb.get();
		}
		else {
			throw new PatientException("Patient with ID : " + patient.getPatientId()+" doesn't exist");
		}
	}
	
	@Override
	public List<Patient> getAllPatient() {
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