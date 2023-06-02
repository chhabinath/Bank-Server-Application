/**
 * 
 */
package com.chhabinath.BankApp.exception;

/**
 * @author Chhabinath Sahoo
 *
 */
@SuppressWarnings("serial")
public class NegativeBalanceException extends RuntimeException {

	/**
	 * @param message
	 */
	public NegativeBalanceException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
