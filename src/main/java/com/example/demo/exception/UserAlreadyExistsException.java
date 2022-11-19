package com.example.demo.exception;

public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1491812956724203709L;

	public UserAlreadyExistsException(String string) {
		System.out.println(string);
	}

}
