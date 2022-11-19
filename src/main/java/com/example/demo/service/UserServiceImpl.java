package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotExistException;
import com.example.demo.model.User;
import com.example.demo.model.UserRequest;
import com.example.demo.repo.UserRepo;
import com.example.demo.strategy.IdCreatorStrategy;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private IdCreatorStrategy strategy;

	@Override
	public long addUser(UserRequest request) {
		long userid=strategy.createId(request);
		if(userRepo.validateUser(userid)) {
			throw new UserAlreadyExistsException("User already exists!!!");
		}
		User user=new User();
		user.setUserid(userid);
		user.setName(user.getName());
		user.setMobile(user.getMobile());
		user.setShoppingCartId(strategy.createShoppingCartId(request));
		
		userRepo.addUser(user);
		return userid;
	}

	@Override
	public User getUser(long userid) throws UserNotExistException {
		if(!userRepo.validateUser(userid)) {
			throw new UserNotExistException("User doesn't exist!!!");
		}
		return null;
	}

}
