package com.example.demo.strategy;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.request.UserRequestObject;

@Service
public class IdCreatorStrategyImpl implements IdCreatorStrategy {
	
	private long uid=0L;
	private long cid=0L;
	private long pid=0L;

	@Override
	public long createId(UserRequestObject request) {
		return uid++;
	}

	@Override
	public long createShoppingCartId(UserRequestObject request) {
		return cid++;
	}

	@Override
	public long createProductId(Product product) {
		return pid++;
	}

}
