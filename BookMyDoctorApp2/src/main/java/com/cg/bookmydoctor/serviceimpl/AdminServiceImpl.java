package com.cg.bookmydoctor.serviceimpl;

     
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.service.IAdminService;
import com.cg.bookmydoctor.dao.*;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if(adminDb.isPresent()) {
			throw new AdminException("Admin Already Exists :" + admin.getAdminId());
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
		Optional<Admin> adminDb = this.adminDao.findById(admin.getAdminId());
		if(adminDb.isPresent()) {
			return adminDb.get();
		}
		else {
			throw new AdminException("Record not found with Id: "+admin.getAdminId());
		}

	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		Optional<Admin> adminDb = this.adminDao.findById(admin.getAdminId());
		if(!adminDb.isPresent()) {
			throw new AdminException("Admin doesn't exists with ID:" + admin.getAdminId());
		}
		else {
			return adminDao.save(admin);
		}

		
	}

}