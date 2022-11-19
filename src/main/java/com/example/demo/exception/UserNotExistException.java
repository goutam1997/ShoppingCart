package com.example.demo.exception;

public class UserNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 618395197466084235L;

	public UserNotExistException(String string) {
		System.out.print(string);
	}

}
