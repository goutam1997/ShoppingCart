package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.example.demo.constant.ProductType;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.request.CartRequestObject;
import com.example.demo.request.UserRequestObject;
import com.example.demo.response.CartDetailResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class ShoppingCartApplicationTests {
	private static final String localHost = "http://localhost:8080";
	
	private static Logger logger = Logger.getLogger(ShoppingCartApplicationTests.class.getName());
	
	private RestTemplate restTemplate = new RestTemplate();
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testHappyPath() {
		createUser();
		viewUser();
		
		addProducts();
		addProductToCart();
		
		viewCart();
	}

	private void viewCart() {
		String actualResponseString = restTemplate.getForObject(localHost+"/cart/{userid}/view", 
				String.class, 0L);
		try {
			CartDetailResponse expectedResponse = mapper.readValue(getClass().getResourceAsStream("resources/CartDetail.json"), 
					CartDetailResponse.class);
			String expectedResponseString = mapper.writeValueAsString(expectedResponse);
			assertEquals(expectedResponseString, actualResponseString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addProductToCart() {
		CartRequestObject request = new CartRequestObject();
		request.setUserid(0L);
		request.setProductid(0L);
		request.setQty(5);		
		restTemplate.postForObject(localHost+"/cart/add", request, Void.class);
		
		request.setProductid(1L);
		request.setQty(2);
		restTemplate.postForObject(localHost+"/cart/add", request, Void.class);
	}

	private void addProducts() {
		Product product = new Product();
		product.setName("rice");
		product.setPrice(45.69);
		product.setType(ProductType.FOOD);
		
		Long productid = restTemplate.postForObject(localHost+"/product/add", 
				product, Long.class);
		assertEquals(0L, productid);
		
		product.setName("shirt");
		product.setPrice(1200);
		product.setType(ProductType.CLOTHES);
		
		productid = restTemplate.postForObject(localHost+"/product/add", 
				product, Long.class);
		assertEquals(1L, productid);
	}

	private void viewUser() {
		User user = restTemplate.getForObject(localHost+"/user/0/details", User.class);

		assertEquals("Goutam", user.getName());
		assertEquals(1234567890L, user.getMobile());
	}

	private void createUser() {
		UserRequestObject request = new UserRequestObject();
		request.setName("Goutam");
		request.setMobile(1234567890);
		
		long userid = restTemplate.postForObject(localHost+"/user/add", request, Long.class);
		assertEquals(0L, userid);
	}

}
