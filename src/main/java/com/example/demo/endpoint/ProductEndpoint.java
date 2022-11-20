package com.example.demo.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductEndpoint {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public long addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@GetMapping("/view")
	public List<Product> viewAllProduct() {
		return productService.viewAllProduct();
	}

	@GetMapping("/view/{productid}")
	public Product viewProduct(@PathVariable long productId) {
		return productService.viewProduct(productId);
	}
}
