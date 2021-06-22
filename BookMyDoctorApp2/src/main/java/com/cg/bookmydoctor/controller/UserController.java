package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import com.cg.bookmydoctor.serviceimpl.UserServiceImpl;

/**
 * @author Shivani
 *         REST Controller with different HTTP methods 
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "user"       
 */
@ComponentScan(basePackages = "com")
@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService ;
   
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody final User user) throws UserException, ValidateUserException {
		return userService.addUser(user);
	}
 
	
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody final User user) throws UserException, ValidateUserException {
		return userService.updateUser(user);
	}

	
	@DeleteMapping("/removeuser")
	public User removeUser(@RequestBody final User user)  throws UserException{
		return userService.removeUser(user);
	}
	
	
	@GetMapping("/getuser/{userId}")
	public User getUser(@PathVariable("userId") final User user) throws UserException {
		return userService.getUser(user);
	}
}


