package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.ProductQty;

public interface CartRepo {
	void addCart(long cartId);
	void addProductToCart(long cartId, ProductQty productQty);
	List<ProductQty> viewCart(long cartid);
}
