package com.example.demo.service;

import com.example.demo.model.UserRequest;
import com.example.demo.exception.UserNotExistException;
import com.example.demo.model.User;

public interface UserService {
	long addUser(UserRequest request);
	User getUser(long userid) throws UserNotExistException;
}
