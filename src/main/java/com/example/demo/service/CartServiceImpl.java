package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotExistException;
import com.example.demo.model.CartRequest;
import com.example.demo.model.Product;
import com.example.demo.model.ProductQty;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CartRepo cartRepo;

	@Override
	public void addToCart(CartRequest request) {
		if(!userRepo.validateUser(request.getUserid())) {
			throw new UserNotExistException();
		}
		long cartid = userRepo.getCartId(request.getUserid());
		Product product = productRepo.getProductById(request.getProductid());
		
		ProductQty productQty = new ProductQty(request.getQty(), product);
		cartRepo.addProductToCart(cartid, productQty);
	}

}
