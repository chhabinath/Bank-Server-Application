package com.chhabinath.BankApp.services;


import com.chhabinath.BankApp.beans.Transaction;

public interface BankServices {

	public double showBalance(int accountNo);

	public double deposit(int accountNo, double amount);

	public double withdraw(int accountNo, double amount);

	public double fundTransfer(int sourceAccountNo, int targetAccountNo, double amount);

	Transaction[] getAllTransactionDetails(int accountNo);

}
