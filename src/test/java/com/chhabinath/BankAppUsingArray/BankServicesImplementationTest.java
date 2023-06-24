/**
 * 
 */
package com.chhabinath.BankAppUsingArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.chhabinath.BankApp.exception.InvalidAccountException;
import com.chhabinath.BankApp.services.BankServices;
import com.chhabinath.BankApp.services.BankServicesImplementation;

/**
 * @author Chhabinath Sahoo
 *
 */
class BankServicesImplementationTest {

	private BankServices bankServices;

	@BeforeAll
	public void setup() {
		bankServices = new BankServicesImplementation();
	}

	@Test
	public void testShowBalance() throws InvalidAccountException {
		int accountNo = 1001;
		double expectedBalance = 10000;

		double balance = bankServices.showBalance(accountNo);

		assertEquals(expectedBalance, balance);
	}
	
	@Test
	public void testDeposit() throws InvalidAccountException {
	    int accountNo = 1001;
	    double initialBalance = bankServices.showBalance(accountNo);
	    double depositAmount = 5000;
	    double expectedBalance = initialBalance + depositAmount;

	    double updatedBalance = bankServices.deposit(accountNo, depositAmount);

	    assertEquals(expectedBalance, updatedBalance);
	}

	@Test
	public void testWithdraw() throws InvalidAccountException {
	    int accountNo = 1001;
	    double initialBalance = bankServices.showBalance(accountNo);
	    double withdrawalAmount = 2000;
	    double expectedBalance = initialBalance - withdrawalAmount;

	    double updatedBalance = bankServices.withdraw(accountNo, withdrawalAmount);

	    assertEquals(expectedBalance, updatedBalance);
	}

}
