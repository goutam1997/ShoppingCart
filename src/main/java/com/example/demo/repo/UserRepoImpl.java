package com.example.demo.repo;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRequest;

@Repository
public class UserRepoImpl implements UserRepo {
	
	private Map<Long, User> userMap = new HashMap<>();

	@Override
	public boolean validateUser(long userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long addUser(long userid, UserRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

}
