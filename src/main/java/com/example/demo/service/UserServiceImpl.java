package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotExistException;
import com.example.demo.model.UserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.repo.UserRepo;
import com.example.demo.strategy.IdCreatorStrategy;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private IdCreatorStrategy strategy;

	@Override
	public long addUser(UserRequest request) {
		long userid=strategy.createId(request.getName(), request.getMobile());
		if(userRepo.validateUser(userid)) {
			throw new UserAlreadyExistsException("User already exists!!!");
		}
		return userRepo.addUser(userid, request);
	}

	@Override
	public UserResponse getUser(long userid) {
		if(!userRepo.validateUser(userid)) {
			throw new UserNotExistException("User doesn't exist!!!");
		}
		return null;
	}

}
