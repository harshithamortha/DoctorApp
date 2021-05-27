package com.cg.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FeedBacks")
public class FeedBack {
	
	@Id
	@Column(name = "ratingId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ratingId;
	
	@OneToOne
	@JoinColumn(name = "patientId",referencedColumnName = "patientId")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name = "doctorId",referencedColumnName = "doctorId")
	private Doctor doctor;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="feedback")
	private String feedback;
	
	public FeedBack() {}
	
	public FeedBack(int ratingId, Patient patient, Doctor doctor, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.patient = patient;
		this.doctor = doctor;
		this.rating = rating;
		this.feedback = feedback;
	}

	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "FeedBack [ratingId=" + ratingId + ", patient=" + patient + ", doctor=" + doctor + ", rating=" + rating
				+ ", feedback=" + feedback + "]";
	}
	
	

}
