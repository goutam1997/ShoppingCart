package com.example.demo.model;

import java.io.Serializable;

import com.example.demo.constant.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5172901122068805622L;

	@JsonIgnore
	private long id;
	
	private String name;
	private double price;
	private ProductType type;
}
