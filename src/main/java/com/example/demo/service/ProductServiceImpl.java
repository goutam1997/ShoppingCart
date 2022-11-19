package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductAlreadyExistsException;
import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.strategy.IdCreatorStrategy;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private IdCreatorStrategy strategy;

	@Override
	public long addProduct(Product product) {
		long productId = strategy.createProductId(product);
		if(productRepo.checkProductExistence(productId)) {
			throw new ProductAlreadyExistsException();
		}
		product.setId(productId);
		productRepo.addProduct(product);
		return productId;
	}

}
