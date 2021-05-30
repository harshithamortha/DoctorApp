package com.cg.bookmydoctor.service;

import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;

public interface IUserService {
	
	public User addUser(User user) throws UserException;
	public User updateUser(User user) throws UserException;
	public User removeUser(User user) throws UserException;
	public User getUser(User user)throws UserException;

}