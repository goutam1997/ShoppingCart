package com.example.demo.repo;

import com.example.demo.model.User;

public interface UserRepo {
	boolean validateUser(long userid);
	void addUser(User user);
}
