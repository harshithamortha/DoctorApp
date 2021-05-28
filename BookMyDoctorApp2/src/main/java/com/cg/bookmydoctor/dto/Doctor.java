package com.cg.bookmydoctor.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "Doctor")
public class Doctor {

	@Id
	@Column(name = "doctorId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int doctorId;
	
	@Size(min = 3, max = 50)
	@NotEmpty(message = "Doctor name is required")
	@Column(name="doctorName")
	private String doctorName;
	
	@NotBlank
	@Column(name="speciality")
	private String speciality;
	
	@NotBlank
	@Column(name="location")
	private String location;
	
	@NotBlank
	@Column(name="hospitalName")
	private String hospitalName;
	
	@NotBlank
	@Column(name="mobileNo")
	private String mobileNo;
	
	@NotBlank
	@Column(name="email")
	private String email;
	
	@NotBlank
	@Column(name="password")
	private String password;
	
	@DecimalMin(value = "500.0")
	@DecimalMax(value = "5000.0")
	@Column(name="chargesPerVisit")
	private double chargesPerVisit;
	
	public Doctor() {}
	
	public Doctor(int doctorId, String doctorName, String speciality, String location, String hospitalName,
			String mobileNo, String email, String password, double chargesPerVisit) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.location=location;
		this.hospitalName = hospitalName;
		this.mobileNo = mobileNo;
		this.email =  email;
		this.password = password;
		this.chargesPerVisit = chargesPerVisit;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getChargesPerVisit() {
		return chargesPerVisit;
	}
	public void setChargesPerVisit(double chargesPerVisit) {
		this.chargesPerVisit = chargesPerVisit;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciality=" + speciality
				+ ", location=" + location + ", hospitalName=" + hospitalName + ", mobileNo=" + mobileNo + ", email="
				+ email + ", password=" + password + ", chargesPerVisit=" + chargesPerVisit + "]";
	}

	
	
	
}
