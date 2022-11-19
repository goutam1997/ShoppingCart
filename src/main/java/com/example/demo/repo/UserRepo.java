package com.example.demo.repo;

import com.example.demo.model.UserRequest;

public interface UserRepo {
	boolean validateUser(long userid);
	long addUser(long userid, UserRequest request);
}
