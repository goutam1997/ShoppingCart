package com.example.demo.strategy;

import com.example.demo.model.UserRequest;

public interface IdCreatorStrategy {
	long createId(UserRequest request);
	long createShoppingCartId(UserRequest request);
}
