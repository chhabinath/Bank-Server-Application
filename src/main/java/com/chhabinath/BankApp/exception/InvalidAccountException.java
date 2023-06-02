package com.chhabinath.BankApp.exception;

@SuppressWarnings("serial")
public class InvalidAccountException extends RuntimeException {

	public InvalidAccountException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
