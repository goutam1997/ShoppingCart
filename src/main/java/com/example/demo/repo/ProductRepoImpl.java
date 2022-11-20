package com.example.demo.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	@Override
	public List<Product> viewAllProduct() {
		return productMap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
	}
}
