package com.cg.bookmydoctor.service;

import java.util.ArrayList;   
import java.util.List;      
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.dao.*;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao docDao;
	Doctor doctor;

	
	@Override
	public List<Doctor> getDoctorList() {
		Iterable<Doctor> result = docDao.findAll();
		List<Doctor> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}
	
	@Override
	public Doctor addDoctor(Doctor dr) {
		if(dr == null) {
			throw new DoctorException("Passed object can't be null");
		} else {
			return docDao.save(dr);
		}
	}

	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		if(bean == null) {
			throw new DoctorException("Passed object can't be null");
		} else {
			return docDao.save(bean);
		}
	}
	
	@Override
	public Doctor removeDoctor(Doctor doc) {
		Doctor dr = doc;
		if(doc == null) {
			throw new DoctorException("The passed object can't be null");

		} else {
			docDao.deleteById(doc.getDoctorId());	
		}
		return dr;
	}
	
	public Doctor getDoctor(Doctor doc) {
		Optional<Doctor> docdb = docDao.findById(doc.getDoctorId());
			return docdb.get();
		
	}
	
	@Override
	public List<Doctor> getDoctorList(String speciality) {
		
		Optional<Doctor> findById = docDao.findBySpeciality(speciality);
		List<Doctor> doclist = new ArrayList<>();
		if (findById.isPresent()) {
			doclist.add(findById.get());
		} else
			throw new DoctorException("Doctor with the speciality : " + speciality + "not exists");

		return doclist;
	}

	@Override
	public boolean updateAvailability(AvailabilityDates bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAvailability(AvailabilityDates bean) {
		// TODO Auto-generated method stub
		return false;
	}

}