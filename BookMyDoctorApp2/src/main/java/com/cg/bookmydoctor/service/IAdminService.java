package com.cg.bookmydoctor.service;


import com.cg.bookmydoctor.dto.Admin;

public interface IAdminService {

	
	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin removeAdmin(Admin admin);
	public Admin viewAdmin(Admin admin);
	
}