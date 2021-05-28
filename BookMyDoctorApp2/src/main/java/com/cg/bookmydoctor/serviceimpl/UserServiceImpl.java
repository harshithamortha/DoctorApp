package com.cg.bookmydoctor.serviceimpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dao.IUserDao;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	
	@Override
	public User addUser(User user) throws UserException{
		Optional<User> userDb = userDao.findById(user.getUserId());
		if(userDb.isPresent()) {
			throw new UserException("User already exists with ID : " +user.getUserId());
		} else {
			return userDao.save(user);
		}
	}

	@Override
	public User updateUser(User user) throws UserException {
		Optional<User> userDb = userDao.findById(user.getUserId());
		if(!userDb.isPresent()) {
			throw new UserException(" User doesn't exists with ID : " +user.getUserId());
		} else {
			return userDao.save(user);
		}
	}

	@Override
	public User removeUser(User user) throws UserException{
		User user1 = user;
		Optional<User> userDb = userDao.findById(user.getUserId());
		if(!userDb.isPresent()) {
			throw new UserException(" User with ID : " +user.getUserId()+" doesn't exist to delete");
		} else {
			userDao.deleteById(user.getUserId());
		}
		return user1;	
	}

	@Override
	public User getUser(User user) throws UserException {
		Optional<User> userDb = userDao.findById(user.getUserId());
		if(userDb.isPresent()) {
			return userDb.get();
		}else {
			throw new UserException(" User doesn't exist with Id : " +user.getUserId());
		} 
	}

}
