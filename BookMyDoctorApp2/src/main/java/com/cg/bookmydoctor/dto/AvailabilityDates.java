package com.cg.bookmydoctor.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Availability_Dates")
public class AvailabilityDates implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "availabiltyId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int availabilityId;
	
	@OneToOne(targetEntity = Doctor.class, cascade = CascadeType.ALL)
	private Doctor doctor;
	
	
	@Column(name="fromDate")
	private LocalDate fromDate;
	
	@Column(name="toDate")
	private LocalDate toDate;
	
	
	public AvailabilityDates() {}


	public AvailabilityDates(int availabilityId, Doctor doctor, LocalDate fromDate, LocalDate toDate) {
		super();
		this.availabilityId = availabilityId;
		this.doctor = doctor;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}


	public int getAvailabilityId() {
		return availabilityId;
	}


	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public LocalDate getFromDate() {
		return fromDate;
	}


	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}


	public LocalDate getToDate() {
		return toDate;
	}


	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}


	@Override
	public String toString() {
		return "AvailabilityDates [availabilityId=" + availabilityId + ", doctor=" + doctor + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	
}
	
	