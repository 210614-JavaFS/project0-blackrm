package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Account;

public interface AccountDAO {

	Account getAccountInfo(int num);

	ArrayList<Account> getAllAccounts();

	double viewBalance(int accountId);

	void openAccount(double begBalance, int customerId);

	String deleteAccount(int accountId);

	String updateAccount(int num, String approved);

}
