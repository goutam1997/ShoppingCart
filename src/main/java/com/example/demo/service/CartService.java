package com.example.demo.service;

import com.example.demo.request.CartRequestObject;
import com.example.demo.response.CartDetailResponse;

public interface CartService {

	void addToCart(CartRequestObject request);

	CartDetailResponse viewCart(long userid);

}
