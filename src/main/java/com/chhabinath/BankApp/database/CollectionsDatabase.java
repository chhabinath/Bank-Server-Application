package com.chhabinath.BankApp.database;

import java.util.ArrayList;
import java.util.List;

import com.chhabinath.BankApp.beans.Account;
import com.chhabinath.BankApp.beans.Customer;
import com.chhabinath.BankApp.beans.Transaction;

/**
 * @author Chhabinath Sahoo
 *
 */
public class CollectionsDatabase {

	List<Account> account;

	List<Transaction> transaction;

	public CollectionsDatabase() {
		transaction = new ArrayList<>();

		account = new ArrayList<>();

		account.add(new Account(1, 1001, 10000, new Customer(1, "Chhabinath Sahoo"), transaction));
		account.add(new Account(2, 1002, 10000, new Customer(2, "Rahul Sahoo"), transaction));
		account.add(new Account(3, 1003, 10000, new Customer(3, "Ankit Aman"), transaction));
		account.add(new Account(4, 1004, 10000, new Customer(4, "Tapaswini Tripathy"), transaction));
		account.add(new Account(5, 1005, 10000, new Customer(5, "Khushi Sinha"), transaction));
		account.add(new Account(6, 1006, 10000, new Customer(6, "Akshat Jain"), transaction));
		account.add(new Account(7, 1007, 10000, new Customer(7, "Ayush Kumar Panda"), transaction));
		account.add(new Account(8, 1008, 10000, new Customer(8, "Chandan Kumar"), transaction));
		account.add(new Account(9, 1009, 10000, new Customer(9, "Aditya Naryan"), transaction));
		account.add(new Account(10, 1010, 10000, new Customer(10, "Misha Bharti"), transaction));

	}

	/**
	 * @return the account
	 */
	public List<Account> getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(List<Account> account) {
		this.account = account;
	}

	/**
	 * @return the transaction
	 */
	public List<Transaction> getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

}
