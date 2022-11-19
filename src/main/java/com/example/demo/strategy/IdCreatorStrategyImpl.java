package com.example.demo.strategy;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserRequest;

@Service
public class IdCreatorStrategyImpl implements IdCreatorStrategy {

	@Override
	public long createId(UserRequest request) {
		return request.getMobile();
	}

	@Override
	public long createShoppingCartId(UserRequest request) {
		return request.getMobile();
	}

}
