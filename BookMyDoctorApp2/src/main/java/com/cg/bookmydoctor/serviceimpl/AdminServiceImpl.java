package com.cg.bookmydoctor.serviceimpl;

     
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.ValidateAdminException;
import com.cg.bookmydoctor.service.IAdminService;
import com.cg.bookmydoctor.util.Constants;
import com.cg.bookmydoctor.dao.IAdminDao;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	public Admin addAdmin(Admin admin) throws AdminException,ValidateAdminException {
		validateAdmin(admin);
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if(adminDb.isPresent()) {
			throw new AdminException("Admin already Exists with ID :" + admin.getAdminId());
		}
		else {
			return adminDao.save(admin);
		}
	}

	@Override
	public Admin removeAdmin(Admin admin) throws AdminException {
		Admin adm = admin;
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if(!adminDb.isPresent()) {
			throw new AdminException("admin with ID : " +admin.getAdminId()+" doesn't exist to delete");
		}else {
			adminDao.deleteById(admin.getAdminId());
		}
		return adm;	
	}

	@Override
	public Admin viewAdmin(Admin admin) throws AdminException{
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if(adminDb.isPresent()) {
			return adminDb.get();
		}
		else {
			throw new AdminException("Admin doesn't exists with ID:"+ admin.getAdminId());
		}

	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if(!adminDb.isPresent()) {
			throw new AdminException("Admin doesn't exists with ID:" + admin.getAdminId());
		}
		else {
			return adminDao.save(admin);
		}	
	}
	
	private boolean validateAdmin(Admin admin) throws ValidateAdminException{
		if (!admin.getAdminName().matches(Constants.NAME_PATTERN) )
			throw new ValidateAdminException(Constants.NAME_CANNOT_BE_EMPTY);
		if (!admin.getContactNumber().matches("[1-9][0-9]{9}")) 
			throw new ValidateAdminException(Constants.PHONENUMBER_CANNOT_BE_EMPTY);
		if (!admin.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new ValidateAdminException(Constants.EMAIL_CANNOT_BE_EMPTY);
		if (!admin.getPassword().matches(Constants.PASSWORD_PATTERN))
			throw new ValidateAdminException(Constants.PASSWORD_NOT_STRONG);
		return true;
		
	}

}