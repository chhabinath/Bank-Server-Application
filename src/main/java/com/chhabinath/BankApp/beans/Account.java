package com.chhabinath.BankApp.beans;

import java.util.List;

/**
 * @author Chhabinath Sahoo
 *
 */
public class Account {

	private int accountId;
	private int accountNumber;
	private double balance;

	private Customer customer;
	private List<Transaction> transaction;

	public Account() {
		super();
	}

	/**
	 * @param accountId
	 * @param accountNumber
	 * @param balance
	 * @param customer
	 * @param transaction
	 */
	public Account(int accountId, int accountNumber, double balance, Customer customer, List<Transaction> transaction) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customer = customer;
		this.transaction = transaction;
	}

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", customer=" + customer + ", transaction=" + transaction + "]";
	}

}
