package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.CartRequestObject;
import com.example.demo.response.CartDetailResponse;
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
	
	@GetMapping("/{userid}/view")
	public CartDetailResponse viewCart(@PathVariable long userid) {
		return cartService.viewCart(userid);
	}
}
