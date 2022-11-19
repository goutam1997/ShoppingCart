package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotExistException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductQty;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.request.CartRequestObject;

@Service
public class CartServiceImpl implements CartService {
	
	private static Logger logger = Logger.getLogger(CartServiceImpl.class.getName());
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CartRepo cartRepo;

	@Override
	public void addToCart(CartRequestObject request) {
		if(!userRepo.validateUser(request.getUserid())) {
			throw new UserNotExistException();
		}
		long cartid = userRepo.getCartId(request.getUserid());
		Product product = productRepo.getProductById(request.getProductid());
		
		ProductQty productQty = new ProductQty(request.getQty(), product);
		cartRepo.addProductToCart(cartid, productQty);
	}

	@Override
	public List<ProductQty> viewCart(long userid) {
		if(!userRepo.validateUser(userid)) {
			throw new UserNotExistException();
		}
		long cartid = userRepo.getCartId(userid);
		return cartRepo.viewCart(cartid);
	}

}
