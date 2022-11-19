package com.example.demo.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.ProductQty;

@Repository
public class CartRepoImpl implements CartRepo {
	
	private Map<Long, ProductQty> cartProductMap = new HashMap<>();

	@Override
	public void addCart(long cartId) {
		
	}

	@Override
	public void addProductToCart(long cartId, ProductQty productQty) {
		// TODO Auto-generated method stub
		
	}

}
