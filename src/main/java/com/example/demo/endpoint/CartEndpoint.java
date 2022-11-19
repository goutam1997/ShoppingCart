package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CartRequest;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartEndpoint {
	
	@Autowired
	private CartService cartService;

	
	@PostMapping("/add")
	public void addToCart(@RequestBody CartRequest request) {
		cartService.addToCart(request);
	}
}
