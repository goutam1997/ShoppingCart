package com.example.demo.service;

import com.example.demo.model.UserRequest;
import com.example.demo.model.UserResponse;

public interface UserService {
	long addUser(UserRequest request);
	UserResponse getUser(long userid);
}
