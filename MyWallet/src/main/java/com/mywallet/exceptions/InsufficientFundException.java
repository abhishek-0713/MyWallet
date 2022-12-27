package com.mywallet.exceptions;

public class InsufficientFundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientFundException() {
		super();
	}

	public InsufficientFundException(String message) {
		super(message);
	}

}
