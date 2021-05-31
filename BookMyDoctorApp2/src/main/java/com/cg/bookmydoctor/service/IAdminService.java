package com.cg.bookmydoctor.service;


import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.ValidateAdminException;

public interface IAdminService {
	
   Admin addAdmin(Admin admin) throws AdminException, ValidateAdminException;
   Admin updateAdmin(Admin admin) throws AdminException, ValidateAdminException;
   Admin removeAdmin(Admin admin) throws AdminException;
   Admin viewAdmin(Admin admin)throws AdminException;
	
}