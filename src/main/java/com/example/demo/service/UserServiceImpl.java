package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotExistException;
import com.example.demo.model.User;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.request.UserRequestObject;
import com.example.demo.strategy.IdCreatorStrategy;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private IdCreatorStrategy strategy;

	@Override
	public long addUser(UserRequestObject request) {
		long userid=strategy.createId(request);
		if(userRepo.validateUser(userid)) {
			throw new UserAlreadyExistsException();
		}
		User user=new User();
		user.setUserid(userid);
		user.setName(request.getName());
		user.setMobile(request.getMobile());
		
		long cartId = strategy.createShoppingCartId(request);
		cartRepo.addCart(cartId);
		user.setShoppingCartId(cartId);
		
		userRepo.addUser(user);
		return userid;
	}

	@Override
	public User getUser(long userid) {
		if(!userRepo.validateUser(userid)) {
			throw new UserNotExistException();
		}
		return userRepo.getUser(userid);
	}

}
