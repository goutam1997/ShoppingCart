package com.example.demo.exception;

import java.util.logging.Logger;

public class ProductAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8601112385138926787L;
	
	private static Logger logger = Logger.getLogger(ProductAlreadyExistsException.class.getName());
	
	public ProductAlreadyExistsException() {
		logger.severe("Product Already Exists!!!");
	}
}
