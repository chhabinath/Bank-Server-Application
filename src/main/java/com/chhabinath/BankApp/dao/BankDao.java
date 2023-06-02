/**
 * 
 */
package com.chhabinath.BankApp.dao;

import com.chhabinath.BankApp.beans.Account;

/**
 * @author Chhabinath Sahoo
 *
 */
public interface BankDao {

	public boolean save(Account account);

	public Account getAccountByNumber(int accountNumber);

}
