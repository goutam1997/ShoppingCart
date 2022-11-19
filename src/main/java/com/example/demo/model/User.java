package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4791326799273146479L;

	@JsonIgnore
	private long userid;
	
	private String name;
	private long mobile;
	
	@JsonIgnore
	private long shoppingCartId;
}
