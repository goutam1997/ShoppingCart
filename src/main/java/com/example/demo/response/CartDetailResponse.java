package com.example.demo.response;

import java.io.Serializable;
import java.util.List;

import com.example.demo.model.ProductQty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDetailResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5172901122068805622L;
	private String name;
	private List<ProductQty> productQties;
	private double cartPrice;
}
