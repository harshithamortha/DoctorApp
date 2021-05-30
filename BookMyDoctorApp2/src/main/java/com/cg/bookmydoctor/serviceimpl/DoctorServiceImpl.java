package com.cg.bookmydoctor.serviceimpl;

import java.util.ArrayList;   
import java.util.List;      
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.service.IDoctorService;
import com.cg.bookmydoctor.dao.*;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao doctorDao;
	Doctor doctor;
	@Autowired
	private IAvailabilityDao availabilityDao;
	
	@Override
	public List<Doctor> getDoctorList() {
		Iterable<Doctor> result = doctorDao.findAll();
		List<Doctor> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}

	
	@Override
	public Doctor addDoctor(Doctor dr) throws DoctorException {
		Optional<Doctor>docdb= doctorDao.findById(dr.getDoctorId());
		if(docdb.isPresent()) {
			throw new DoctorException("Doctor object already exists with ID : " +dr.getDoctorId());
		} else {
			return doctorDao.save(dr);
		}
	}

	@Override
	public Doctor updateDoctorProfile(Doctor bean) throws DoctorException {
		Optional<Doctor>docdb = doctorDao.findById(bean.getDoctorId());
		if(!docdb.isPresent()) {
			throw new DoctorException("Doctor doesn't exist with ID : " +bean.getDoctorId());
		} else {
			return doctorDao.save(bean);
		}
	}


	@Override
	public Doctor removeDoctor(Doctor doc) throws DoctorException {
		Doctor doctor = doc;
		Optional<Doctor> docdb = doctorDao.findById(doc.getDoctorId());
		if(!docdb.isPresent()) {
			throw new DoctorException("Doctor with id : " +doc.getDoctorId() +"doesn't exist to delete");

		} else {
			doctorDao.deleteById(doc.getDoctorId());	
		}
		return doctor;
	}


	public Doctor getDoctor(Doctor doc) throws DoctorException {
		Optional<Doctor> docdb = doctorDao.findById(doc.getDoctorId());
		if(docdb.isPresent()) {
			return docdb.get();
		} else {
			throw new DoctorException("Doctor with id : " +doc.getDoctorId() +"doesn't exist");
		}

	}


	@Override
	public List<Doctor> getDoctorList(String speciality) throws DoctorException {
		Optional<Doctor> doctorDb = doctorDao.findBySpeciality(speciality);
		List<Doctor> doclist = new ArrayList<>();
		if (doctorDb .isPresent()) {
			doclist.add(doctorDb .get());
		} else
			throw new DoctorException("Doctor with the speciality : " + speciality + "not exists");

		return doclist;
	}


	public boolean addAvailability(AvailabilityDates availDates) {
		if(availDates != null) {
			Optional<AvailabilityDates> availabilityDb = availabilityDao.findById(availDates.getAvailabilityId());
			if(!availabilityDb.isPresent()) {
				availabilityDao.save(availDates);
				return true;
			}

		}	
		return false;
	}

	public boolean updateAvailability(AvailabilityDates availDates) {
		Optional<AvailabilityDates> availabilityDb = availabilityDao.findById(availDates.getAvailabilityId());
		if(availabilityDb.isPresent()) {
			availabilityDao.save(availDates);
			return true;	

		} else {
			return false;
		}
	}

}