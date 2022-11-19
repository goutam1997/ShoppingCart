package com.example.demo.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductQty;

@Repository
public class CartRepoImpl implements CartRepo {
	
	private Map<Long, Map<Long, ProductQty>> cartProductMap = new HashMap<>();

	@Override
	public void addCart(long cartId) {
		cartProductMap.put(cartId, new HashMap<>());
	}

	@Override
	public void addProductToCart(long cartId, ProductQty productQty) {
		cartProductMap.get(cartId).put(productQty.getProduct().getId(), productQty);
	}

	@Override
	public List<ProductQty> viewCart(long cartid) {
		return cartProductMap.get(cartid)
				.entrySet()
				.stream()
				.map(entry -> entry.getValue())
				.collect(Collectors.toList());
	}

}
