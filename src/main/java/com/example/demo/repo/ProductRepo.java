package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductRepo {
	Product getProductById(long id);

	boolean checkProductExistence(long productId);

	void addProduct(Product product);

	List<Product> viewAllProduct();
}
