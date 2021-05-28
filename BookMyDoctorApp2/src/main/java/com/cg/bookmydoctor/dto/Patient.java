package com.cg.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Patient")
public class Patient  {
	
	@Id
	@Column(name = "patientId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patientId;
	
	@Size(min = 3, max = 50)
	@NotEmpty(message = "Patient name is required")
	@Column(name="patientName")
	private String patientName;
	
	@NotBlank
	@Column(name="mobileNo")
	private String mobileNo;
	
	@NotBlank
	@Email(message = "Please enter a valid e-mail address")
	@Column(name="email")
	private String email;
	
	@Size(min = 8, max = 15)
	@Column(name="password")
	private String password;
	
	@NotBlank
	@Column(name="bloodGroup")
	private String bloodGroup;
	
	@NotBlank
	@Column(name="gender")
	private String gender;
	
	//@NotEmpty
	@Column(name="age")
	private int age;
	
	@NotBlank
	@Column(name="address")
	private String address;
	
	/*@OneToOne(mappedBy = "patient")
	private Appointment appointment;*/
	
	public Patient() {
		
	} 
	
	public Patient(int patientId, String patientName, String mobileNo, String email, String password, String bloodGroup,
			String gender, int age, String address) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", password=" + password + ", bloodGroup=" + bloodGroup + ", gender=" + gender
				+ ", age=" + age + ", address=" + address + "]";
	}
	
}
