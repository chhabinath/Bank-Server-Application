/**
 * 
 */
package com.chhabinath.BankApp.dao;

import com.chhabinath.BankApp.beans.Account;
import com.chhabinath.BankApp.database.ArrayDatabase;

/**
 * @author Chhabinath Sahoo
 *
 */
public class BankDaoImplementation implements BankDao{

	ArrayDatabase arrayDatabase;

	public BankDaoImplementation() {
		arrayDatabase = new ArrayDatabase();
	}

	@Override
	public boolean save(Account account) {
		return false;
	}

	@Override
	public Account getAccountByNumber(int accountNumber) {

		Account[] account = arrayDatabase.getAccount();
		for (int i = 0; i < account.length; i++) {
			if (account[i].getAccountNumber() == accountNumber)
				return account[i];
		}
		return null;
	}

}
