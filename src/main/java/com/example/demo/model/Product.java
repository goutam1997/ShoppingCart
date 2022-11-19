package com.example.demo.model;

import com.example.demo.constant.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	@JsonIgnore
	private long id;
	
	private String name;
	private ProductType productType;
}
