package com.cg.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "userId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
		
	private String userEmail;
	
	private String password;
	
	private String role; // admin//doctor //patient
	
	public User() {
		
	}

	public User(int userId, String userEmail, String password, String role) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", password=" + password + ", role=" + role
				+ "]";
	}
	
}
