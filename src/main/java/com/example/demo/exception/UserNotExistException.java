package com.example.demo.exception;

public class UserNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 618395197466084235L;

	public UserNotExistException() {
		System.out.print("User doesn't exist!!!");
	}

}
