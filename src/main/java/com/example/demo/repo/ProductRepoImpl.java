package com.example.demo.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public class ProductRepoImpl implements ProductRepo {
	
	private Map<Long, Product> productMap=new HashMap<>();
	
	public void addProduct(Product product) {
		productMap.put(product.getId(), product);
	}

	@Override
	public Product getProductById(long id) {
		return productMap.get(id);
	}

	@Override
	public boolean checkProductExistence(long productId) {
		return productMap.containsKey(productId);
	}

}
