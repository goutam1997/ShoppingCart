package com.example.demo.exception;

import java.util.logging.Logger;

public class UserNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 618395197466084235L;
	
	private static Logger logger = Logger.getLogger(UserNotExistException.class.getName());

	public UserNotExistException() {
		logger.severe("User doesn't exist!!!");
	}

}
