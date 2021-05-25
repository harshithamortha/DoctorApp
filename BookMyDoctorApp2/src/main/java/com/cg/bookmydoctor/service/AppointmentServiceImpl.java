package com.cg.bookmydoctor.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.dao.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
		@Autowired
		private IAppointmentDao appointmentDao;
		
		@Override
		public List<Appointment> getAllAppointments() {
			Iterable<Appointment> result = appointmentDao.findAll();
			List<Appointment> resultList = new ArrayList<>();
			result.forEach(resultList :: add);
			return resultList;
		}

		@Override
		public Appointment getAppointment(int appointmentId) {
			// TODO Auto-generated method stub
	        Optional<Appointment> appointmentDb = this.appointmentDao.findById(appointmentId);
			if(appointmentDb.isPresent()) {
				return appointmentDb.get();
			}else {
				throw new AppointmentException("Record not found with id : " + appointmentId);
			}
		}
		
	    private Appointment appointment;
		@Override
		public boolean deleteAppointment(int appointmentId) {
			if(appointmentId == appointment.getAppointmentId()) {
				appointmentDao.deleteById(appointmentId);
				return true;		
			} 
			return false;
		}

		@Override
		public boolean updateAppointment(Appointment bean) {
			// TODO Auto-generated method stub
			if(bean.getAppointmentId() == appointment.getAppointmentId()) {
				appointment.setAppointmentId(bean.getAppointmentId());
				appointment.setDoctor(bean.getDoctor());
				appointment.setPatient(bean.getPatient());
				appointment.setAppointmentDate(bean.getAppointmentDate());
				appointment.setAppointmentStatus(bean.getAppointmentStatus());
				return true;		
			}
			return false;
		}
	    
		private Doctor dr;
		@Override
		public List<Appointment> getAppointments(Doctor doc) {
			// TODO Auto-generated method stub
			List<Appointment> appt  = new ArrayList<>();
			if(appointment.getDoctor() == doc) {
				appt.add(appointment);
			}
			return appt;
		}

		@Override
		public List<Appointment> getAppointments(LocalDate doc) {
			// TODO Auto-generated method stub
			LocalDate localDate = appointment.getAppointmentDate().toLocalDate();
			List<Appointment> appt  = new ArrayList<>();
			if(localDate == doc) {
				appt.add(appointment);	
			}
			return appt;
		}

}
