package com.revature.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.MenuController;
import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

public class AccountService {
	
	Account account = new Account();
	AccountDAO accountDAO = new AccountDAOImpl();
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	public Account getAccountInfo(int num) {
		// TODO Auto-generated method stub
		account = accountDAO.getAccountInfo(num);
		return account;
	}

	public void updateAccountInfo(int num, String approved) {
		// TODO Auto-generated method stub
		logger.debug("updating account " + num);
		String resp = accountDAO.updateAccount(num, approved);
		System.out.println(resp);
		return;
	}

	public boolean validateNumber(double num) {
		// TODO Auto-generated method stub
		logger.debug("making sure number passed in is not less than 0");
		boolean myState = true;
		if(num < 0)
			myState = false;
		return myState;
	}

	public void openAccount(double begBalance, int customerId) {
		// TODO Auto-generated method stub
		
		logger.debug("opening account for " + customerId);
		accountDAO.openAccount(begBalance, customerId);
		return;
	}

	public void viewBalance(int accountId) {
		// TODO Auto-generated method stub
		logger.debug("viewing balance of account " + accountId);
		double balance = accountDAO.viewBalance(accountId);
		System.out.println("Account Id: " + accountId);
		System.out.println("Account Balance: $" + balance);
		return;
		
	}

	public void deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		logger.debug("deleting account " + accountId);
		String resp = accountDAO.deleteAccount(accountId);
		System.out.println(resp);
		return;
	}

	public void viewAllAccounts() {
		// TODO Auto-generated method stub
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts = accountDAO.getAllAccounts();
		int counter = 0;
		System.out.println("ID  \t  CustomerId  \t  Balance");
		while(counter < accounts.size()) {
			System.out.println(accounts.get(counter).getId() + "\t" + "\t" + 
					accounts.get(counter).getCustomerId() + "\t" +  "   " + "$" + accounts.get(counter).getBalance());
			counter++;
		}
		return;
		
	}

}
