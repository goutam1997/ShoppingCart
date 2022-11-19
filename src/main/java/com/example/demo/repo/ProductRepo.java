package com.example.demo.repo;

import com.example.demo.model.Product;

public interface ProductRepo {
	Product getProductById(long id);
}
