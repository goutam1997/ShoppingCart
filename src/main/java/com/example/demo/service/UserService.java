package com.example.demo.service;

import com.example.demo.exception.UserNotExistException;
import com.example.demo.model.User;
import com.example.demo.request.UserRequestObject;

public interface UserService {
	long addUser(UserRequestObject request);
	User getUser(long userid) throws UserNotExistException;
}
