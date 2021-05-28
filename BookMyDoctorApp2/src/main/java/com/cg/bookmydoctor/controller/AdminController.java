package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.serviceimpl.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminservice ;
	
	//working
   	@GetMapping("/viewadmin")
	public Admin viewAdmin(@RequestParam("adminId") Admin admin) {
		return adminservice.viewAdmin(admin);
	}

    //working
	@PostMapping("/addadmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminservice.addAdmin(admin);
	}

	//working
	@PutMapping("/updateadmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminservice.updateAdmin(admin);
	}

	//working
	@DeleteMapping("/removeadmin")
	public Admin removeAdmin(@RequestBody Admin admin) {
		return adminservice.removeAdmin(admin);
	}
}