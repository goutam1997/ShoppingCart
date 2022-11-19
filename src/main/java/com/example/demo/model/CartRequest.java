package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
	private long userid;
	private long productid;
	private int qty;
}
