package com.chhabinath.BankApp.services;

import com.chhabinath.BankApp.beans.Account;
import com.chhabinath.BankApp.beans.Transaction;
import com.chhabinath.BankApp.dao.BankDao;
import com.chhabinath.BankApp.dao.BankDaoImplementation;
import com.chhabinath.BankApp.database.ArrayDatabase;
import com.chhabinath.BankApp.exception.InsufficientBalanceException;
import com.chhabinath.BankApp.exception.InvalidAccountException;
import com.chhabinath.BankApp.exception.NegativeBalanceException;

/**
 * @author Chhabinath Sahoo
 *
 */
public class BankServicesImplementation implements BankServices {

	BankDao bankDao;

	public BankServicesImplementation() {
		bankDao = new BankDaoImplementation();
	}

	public static int id = 0;
	ArrayDatabase arrayDatabase = new ArrayDatabase();

	/**
	 * Retrieves the balance of the specified account number.
	 *
	 * @param accountNo the account number for which to retrieve the balance
	 * @return the balance of the account
	 * @throws InvalidAccountException if the account number is invalid or does not
	 *                                 exist
	 */
	@Override
	public double showBalance(int accountNo) throws InvalidAccountException {

		Account account = bankDao.getAccountByNumber(accountNo);
		try {
			return account.getBalance();
		} catch (NullPointerException e) {
			throw new InvalidAccountException("Account Not Found");
		}
	}

	/**
	 * Deposits the specified amount into the account with the given account number.
	 *
	 * @param accountNo the account number for which to deposit the amount
	 * @param amount    the amount to be deposited
	 * @return the updated balance after the deposit
	 * @throws InvalidAccountException  if the account number is invalid or does not
	 *                                  exist
	 * @throws NegativeBalanceException if the amount is less than 0
	 */

	@Override
	public double deposit(int accountNo, double amount) {
		Account account = bankDao.getAccountByNumber(accountNo);
		if (account == null) {
			throw new InvalidAccountException("Account Not Found");
		}

		if (amount < 0) {
			throw new NegativeBalanceException("Amount must be greater than or equal to 0");
		}

		double updatedBalance = account.getBalance() + amount;
		account.setBalance(updatedBalance);
		Transaction[] transactions = account.getTransaction();
		transactions[id] = new Transaction(id++, amount, "Deposit");
		return updatedBalance;
	}

	/**
	 * Withdraws the specified amount from the account with the given account
	 * number.
	 *
	 * @param accountNo the account number from which to withdraw the amount
	 * @param amount    the amount to be withdrawn
	 * @return the updated balance after the withdrawal
	 * @throws InvalidAccountException      if the account number is invalid or does
	 *                                      not exist
	 * @throws NegativeBalanceException     if the amount is less than 0
	 * @throws InsufficientBalanceException if the account balance is less than the
	 *                                      withdrawal amount
	 */

	@Override
	public double withdraw(int accountNo, double amount) {
		Account account = bankDao.getAccountByNumber(accountNo);
		if (account == null) {
			throw new InvalidAccountException("Account Not Found");
		}

		if (amount < 0) {
			throw new NegativeBalanceException("Amount must be greater than or equal to 0");
		}

		if (account.getBalance() < amount) {
			throw new InsufficientBalanceException("Insufficient Account Balance");
		}

		double updatedBalance = account.getBalance() - amount;
		account.setBalance(updatedBalance);
		Transaction[] transactions = account.getTransaction();
		transactions[id] = new Transaction(id++, amount, "withdraw");
		return updatedBalance;
	}

	/**
	 * Transfers the specified amount from the source account to the target account.
	 *
	 * @param sourceAccountNo the account number from which to transfer the amount
	 * @param targetAccountNo the account number to which the amount will be
	 *                        transferred
	 * @param amount          the amount to be transferred
	 * @return the updated balance of the source account after the transfer
	 * @throws InvalidAccountException      if the source or target account numbers
	 *                                      are invalid or do not exist
	 * @throws NegativeBalanceException     if the amount is less than 0
	 * @throws InsufficientBalanceException if the source account balance is less
	 *                                      than the transfer amount
	 */

	@Override
	public double fundTransfer(int sourceAccountNo, int targetAccountNo, double amount) {

		// Withdraw from the source account
		withdraw(sourceAccountNo, amount);

		// Deposit into the target account
		deposit(targetAccountNo, amount);

		// Return the updated balance of the source account
		return withdraw(sourceAccountNo, amount);
	}

	/**
	 * Retrieves the last 10 transactions for the specified account number.
	 *
	 * @param accountNo the account number for which to retrieve the transactions
	 * @return an array of the last 10 transactions for the account
	 * @throws InvalidAccountException if the account number is invalid or does not
	 *                                 exist
	 */

	@Override
	public Transaction[] getAllTransactionDetails(int accountNo) {
		Account account = bankDao.getAccountByNumber(accountNo);
		if (account == null) {
			throw new InvalidAccountException("Account Not Found");
		}

		Transaction[] transactions = account.getTransaction();
		int length = transactions.length;
		int startIndex = Math.max(0, length - 10); // Start index for the last 10 transactions
		int numTransactions = Math.min(10, length); // Number of transactions to retrieve

		Transaction[] last10Transactions = new Transaction[numTransactions];
		for (int i = 0; i < numTransactions; i++) {
			last10Transactions[i] = transactions[startIndex + i];
		}

		return last10Transactions;
	}

}
