package com.cg.bookmydoctor.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.service.IAppointmentService;
import com.cg.bookmydoctor.dao.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		public Appointment addAppointment(Appointment appointment) throws AppointmentException {
			if(appointment == null) {
				throw new AppointmentException("Passed object cannot be null");
			} else {
				return appointmentDao.save(appointment);
			}
		}

		@Override
		public Appointment getAppointment(int appointmentId) throws AppointmentException {
	        Optional<Appointment> appointmentDb = this.appointmentDao.findById(appointmentId);
			if(appointmentDb.isPresent()) {
				return appointmentDb.get();
			}else {
				throw new AppointmentException("Record not found with id : " +appointmentId);
			}
		}
		
	    private Appointment appointment;
		@Override
		public boolean deleteAppointment(int appointmentId) throws AppointmentException {
			if(appointmentId > 0) {
				appointmentDao.deleteById(appointmentId);
				return true;		
			} 
			return false;
		}

		@Override
		public boolean updateAppointment(Appointment bean) throws AppointmentException{
			if(bean == null) {
				throw new AppointmentException("Passed object can't be null");
			} else {
				appointmentDao.save(bean);
				return true;
			}
		}

		@Override
		public List<Appointment> getAppointments(Doctor doc) {
			List<Appointment> appt  = new ArrayList<>();
			if(appointment.getDoctor().getDoctorId() == doc.getDoctorId()) {
				appt.add(appointment);
			}
			return appt;
		}

		@Override
		public List<Appointment> getAppointments(LocalDate date) {
			return appointmentDao.findAllByAppointmentDate(date);
		}

}