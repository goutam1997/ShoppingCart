package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ProductQty;
import com.example.demo.request.CartRequestObject;

public interface CartService {

	void addToCart(CartRequestObject request);

	List<ProductQty> viewCart(long userid);

}
