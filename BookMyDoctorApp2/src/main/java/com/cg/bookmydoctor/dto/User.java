package com.cg.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "userId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Size(min = 3, max = 50)
	@NotEmpty(message = "Username is required")
	@Column(name="userName")
	private String userName;
	
	@Size(min = 8, max = 15)
	@Column(name="password")
	private String password;
	
	@NotBlank
	@Column(name="role")
	private String role; // admin//doctor //patient
	
	public User() {
		
	}
	
	public User(int userId, String userName, String password, String role) {
		super();
		this.userId = userId;
		this.userName =  userName;
		this.password = password;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}


}
