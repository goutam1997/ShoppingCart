package com.example.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5172901122068805622L;
	private int qty;
	private Product product;
	private double totalPrice;
}
