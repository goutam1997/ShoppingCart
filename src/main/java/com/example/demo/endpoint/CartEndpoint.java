package com.example.demo.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductQty;
import com.example.demo.request.CartRequestObject;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartEndpoint {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public void addToCart(@RequestBody CartRequestObject request) {
		cartService.addToCart(request);
	}
	
	@GetMapping("/view")
	public List<ProductQty> viewCart(@RequestBody CartRequestObject request) {
		return cartService.viewCart(request.getUserid());
	}
}
