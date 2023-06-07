/**
 * This class represents the main entry point of the BankApp application.
 */
package com.chhabinath.BankApp.main;

import java.util.Scanner;

import com.chhabinath.BankApp.beans.Transaction;
import com.chhabinath.BankApp.exception.InsufficientBalanceException;
import com.chhabinath.BankApp.exception.InvalidAccountException;
import com.chhabinath.BankApp.exception.NegativeBalanceException;
import com.chhabinath.BankApp.services.BankServices;
import com.chhabinath.BankApp.services.BankServicesImplementation;

/**
 * @author Chhabinath Sahoo
 * 
 *         This class implements the main function to run the BankApp
 *         application.
 */
public class BankMain {

	/**
	 * The main entry point of the BankApp application.
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		BankServices bankServices = new BankServicesImplementation();

		Scanner scanner = new Scanner(System.in);

		boolean exit = false;

		while (!exit) {
			System.out.println("===============================");
			System.out.println("           Bank App Menu       ");
			System.out.println("===============================");
			System.out.println("1. Show Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Fund Transfer");
			System.out.println("5. Get Last 10 Transactions");
			System.out.println("0. Exit");
			System.out.println("===============================");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter account number: ");
				int accountNo = scanner.nextInt();

				try {
					double balance = bankServices.showBalance(accountNo);
					System.out.println("Balance: " + balance);
				} catch (InvalidAccountException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				System.out.println("Enter account number: ");
				int depositeAccountNo = scanner.nextInt();

				System.out.print("Enter amount to deposit: ");
				double depositeAmount = scanner.nextDouble();

				try {
					double balance = bankServices.deposit(depositeAccountNo, depositeAmount);
					System.out.println("Deposit successful. \nUpdated balance: " + balance);
				} catch (InvalidAccountException | NegativeBalanceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.print("Enter account number: ");
				int withdrawAccountNo = scanner.nextInt();

				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = scanner.nextDouble();

				try {
					double balance = bankServices.withdraw(withdrawAccountNo, withdrawAmount);
					System.out.println("Withdrawal successful. \nUpdated balance: " + balance);
				} catch (InvalidAccountException | NegativeBalanceException | InsufficientBalanceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.print("Enter the source account number: ");
				int sourceAccountNo = scanner.nextInt();
				System.out.print("Enter the target account number: ");
				int targetAccountNo = scanner.nextInt();
				System.out.print("Enter the amount to transfer: ");
				double amount = scanner.nextDouble();
				try {
					double sourceBalance = bankServices.fundTransfer(sourceAccountNo, targetAccountNo, amount);
					System.out.println("Fund transfer successful. Source account balance: " + sourceBalance);
				} catch (InvalidAccountException | NegativeBalanceException | InsufficientBalanceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.print("Enter the account number: ");
				int accountNo1 = scanner.nextInt();
				try {
					Transaction[] transactions = bankServices.getAllTransactionDetails(accountNo1);
					System.out.println("Last 10 Transactions:");
					for (Transaction transaction : transactions) {
						if (transaction != null)
							System.out.println(transaction);
					}
				} catch (InvalidAccountException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 0:
				System.out.println("Exiting... Goodbye!");
				exit = true; // Set exit flag to true to exit the loop
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
				break;

			}
			System.out.println();

		}
		scanner.close();

	}

}
