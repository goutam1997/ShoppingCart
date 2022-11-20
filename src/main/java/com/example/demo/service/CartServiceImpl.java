package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductNotExistException;
import com.example.demo.exception.UserNotExistException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductQty;
import com.example.demo.model.User;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.request.CartRequestObject;
import com.example.demo.response.CartDetailResponse;

@Service
public class CartServiceImpl implements CartService {
	
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
		if(!productRepo.checkProductExistence(request.getProductid())) {
			throw new ProductNotExistException();
		}
		Product product = productRepo.getProductById(request.getProductid());
		
		ProductQty productQty = new ProductQty(request.getQty(), product, product.getPrice() * request.getQty());
		cartRepo.addProductToCart(cartid, productQty);
	}

	@Override
	public CartDetailResponse viewCart(long userid) {
		if(!userRepo.validateUser(userid)) {
			throw new UserNotExistException();
		}
		User user = userRepo.getUser(userid);
		
		CartDetailResponse response = new CartDetailResponse();
		response.setName(user.getName());
		
		response.setProductQties(cartRepo.viewCart(user.getShoppingCartId()));
		double cartPrice = 0;
		for(ProductQty productQty : response.getProductQties()) {
			cartPrice += productQty.getTotalPrice();
		}
		response.setCartPrice(cartPrice);
		return response;
	}

}
