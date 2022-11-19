package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	@JsonIgnoreProperties
	private long userid;
	
	private String name;
	private long mobile;
	
	@JsonIgnoreProperties
	private long shoppingCartId;
}
