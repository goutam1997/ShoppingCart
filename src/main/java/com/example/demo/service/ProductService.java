package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	long addProduct(Product product);

	List<Product> viewAllProduct();

	Product viewProduct(long productId);
}
