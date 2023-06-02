/**
 * 
 */
package com.chhabinath.BankApp.main;

import com.chhabinath.BankApp.exception.InsufficientBalanceException;
import com.chhabinath.BankApp.exception.InvalidAccountException;
import com.chhabinath.BankApp.exception.NegativeBalanceException;
import com.chhabinath.BankApp.services.BankServices;
import com.chhabinath.BankApp.services.BankServicesImplementation;

/**
 * @author Chhabinath Sahoo
 *
 */
public class BankMain {

	/**
	 * @param args
	 * @throws InvalidAccountException
	 * @throws NegativeBalance 
	 */
	public static void main(String[] args) {

		BankServices bankServices = new BankServicesImplementation();

		try {
			double balance = bankServices.showBalance(1001);
			System.out.println(balance);
			System.out.println(bankServices.deposit(1001, 300));
			
			System.out.println(bankServices.withdraw(1001, 500));
			
			System.out.println(bankServices.fundTransfer(1001, 1002, 11000));
			
			System.out.println(bankServices.showBalance(1001));
			
		} catch (InvalidAccountException | NegativeBalanceException | InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
