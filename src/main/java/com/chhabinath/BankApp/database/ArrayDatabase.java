package com.chhabinath.BankApp.database;

import com.chhabinath.BankApp.beans.Account;
import com.chhabinath.BankApp.beans.Customer;
import com.chhabinath.BankApp.beans.Transaction;

/**
 * @author Chhabinath Sahoo
 *
 */
public class ArrayDatabase {

	Account[] account;

	Transaction[] transaction;

	public ArrayDatabase() {
		Transaction[] transaction = new Transaction[10];

		account = new Account[10];

		account[0] = new Account(1, 1001, 10000, new Customer(1, "Chhabinath Sahoo"), transaction);
		account[1] = new Account(2, 1002, 10000, new Customer(2, "Rahul Sahoo"), transaction);
		account[2] = new Account(3, 1003, 10000, new Customer(3, "Ankit Aman"), transaction);
		account[3] = new Account(4, 1004, 10000, new Customer(4, "Tapaswini Tripathy"), transaction);
		account[4] = new Account(5, 1005, 10000, new Customer(5, "Khushi Sinha"), transaction);
		account[5] = new Account(6, 1006, 10000, new Customer(6, "Akshat Jain"), transaction);
		account[6] = new Account(7, 1007, 10000, new Customer(7, "Ayush Kumar Panda"), transaction);
		account[7] = new Account(8, 1008, 10000, new Customer(8, "Chandan Kumar"), transaction);
		account[8] = new Account(9, 1009, 10000, new Customer(9, "Aditya Naryan"), transaction);
		account[9] = new Account(10, 1010, 10000, new Customer(10, "Misha Bharti"), transaction);

	}

	/**
	 * @return the account
	 */
	public Account[] getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account[] account) {
		this.account = account;
	}

	/**
	 * @return the transaction
	 */
	public Transaction[] getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(Transaction[] transaction) {
		this.transaction = transaction;
	}

}
