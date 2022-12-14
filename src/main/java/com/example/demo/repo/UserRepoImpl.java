package com.example.demo.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepoImpl implements UserRepo {
	
	private Map<Long, User> userMap = new HashMap<>();

	@Override
	public boolean validateUser(long userid) {
		return userMap.containsKey(userid);
	}

	@Override
	public void addUser(User user) {
		userMap.put(user.getUserid(), user);
	}

	@Override
	public User getUser(long userid) {
		return userMap.get(userid);
	}

	@Override
	public long getCartId(long userid) {
		return userMap.get(userid).getShoppingCartId();
	}

}
