/**
 * 
 */
package com.chhabinath.BankApp.exception;

/**
 * @author Chhabinath Sahoo
 *
 */
@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException {

	/**
	 * 
	 */
	public InsufficientBalanceException(String msg) {
		super(msg);
	}

}
