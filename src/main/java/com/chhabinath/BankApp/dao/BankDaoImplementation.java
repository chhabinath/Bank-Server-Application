/**
 * 
 */
package com.chhabinath.BankApp.dao;

import java.util.ArrayList;
import java.util.List;

import com.chhabinath.BankApp.beans.Account;
import com.chhabinath.BankApp.database.CollectionsDatabase;

/**
 * @author Chhabinath Sahoo
 *
 */
public class BankDaoImplementation implements BankDao{

	private List<Account> accountList;
	
	CollectionsDatabase collectionsDatabase;

	public BankDaoImplementation() {
		 accountList = new ArrayList<>();
		 collectionsDatabase = new CollectionsDatabase();
	}

	@Override
	public boolean save(Account account) {
		return false;
	}

	@Override
	public Account getAccountByNumber(int accountNumber) {

		accountList.addAll(collectionsDatabase.getAccount());
		for (Account account : accountList) {
			if (account.getAccountNumber() == accountNumber)
				return account;
		}
		return null;
	}

}
