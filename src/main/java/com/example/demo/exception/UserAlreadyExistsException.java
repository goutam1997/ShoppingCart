package com.example.demo.exception;

import java.util.logging.Logger;

public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1491812956724203709L;
	
	private static Logger logger = Logger.getLogger(UserAlreadyExistsException.class.getName());

	public UserAlreadyExistsException() {
		logger.severe("User already exists!!!");
	}

}
