package com.example.demo.strategy;

import com.example.demo.model.Product;
import com.example.demo.request.UserRequestObject;

public interface IdCreatorStrategy {
	long createId(UserRequestObject request);
	long createShoppingCartId(UserRequestObject request);
	long createProductId(Product product);
}
