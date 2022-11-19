package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestObject {
	private long userid;
	private long productid;
	private int qty;
}
