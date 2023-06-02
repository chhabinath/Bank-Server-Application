/**
 * 
 */
package com.chhabinath.BankApp.beans;

/**
 * @author Chhabinath Sahoo
 *
 */
public class Transaction {

	int transactionId;
	double transactionAmount;
	String trancetionType;

	/**
	 * 
	 */
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param transactionId
	 * @param transactionAmount
	 * @param trancetionType
	 */
	public Transaction(int transactionId, double transactionAmount, String trancetionType) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.trancetionType = trancetionType;
	}

	/**
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionAmount
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the trancetionType
	 */
	public String getTrancetionType() {
		return trancetionType;
	}

	/**
	 * @param trancetionType the trancetionType to set
	 */
	public void setTrancetionType(String trancetionType) {
		this.trancetionType = trancetionType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", trancetionType=" + trancetionType + "]";
	}

}
