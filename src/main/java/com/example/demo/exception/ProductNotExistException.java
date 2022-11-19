package com.example.demo.exception;

import java.util.logging.Logger;

public class ProductNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8601112385138926787L;
	
	private static Logger logger = Logger.getLogger(ProductNotExistException.class.getName());
	
	public ProductNotExistException() {
		logger.severe("Product Does Not Exist!!!");
	}
}
