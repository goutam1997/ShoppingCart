package com.example.demo.repo;

import com.example.demo.model.ProductQty;

public interface CartRepo {
	void addCart(long cartId);
	void addProductToCart(long cartId, ProductQty productQty);
}
