package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.services.AccountService;
import com.revature.services.CustomerService;

public class AccountController {
	
	AccountService accountService = new AccountService();
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	private static Scanner scanner = new Scanner(System.in);
	CustomerService customerService = new CustomerService();
	
	public void viewAccountData() {
		logger.debug("getting account data");
		System.out.println("Please enter the account number:  ");
		int num = scanner.nextInt();
		Account account = new Account();
		account = accountService.getAccountInfo(num);
		if(account != null) {
			System.out.println("ID: " + account.getId());
			System.out.println("Customer ID: " + account.getCustomerId());
			System.out.println("Balance: $" + account.getBalance());
		}
		else
			System.out.println("Account not found");
		return;
		
	}

	public void viewCustomerData() {
		logger.debug("viewing customer data");
		System.out.println("Please enter the customer ID:  ");
		int num = scanner.nextInt();
		Customer customer = new Customer();
		customer = customerService.getCustomerInfo(num);
		if(customer != null) {
			System.out.println("ID: " + customer.getId());
			System.out.println("Customer Name: " + customer.getName());
			System.out.println("Customer Username: " + customer.getUsername());
			System.out.println("Customer Join Date: " + customer.getJoin_date());
		}
		else
			System.out.println("Customer not found");
		return;
	}


	public void updateAccountData() {
		logger.debug("Approving or denying account");
		System.out.println("Please enter the account number:  ");
		String approved = "";
		int num = scanner.nextInt();
		System.out.println("How can we help you today? \n"
			+ "1) Approve account \n"
			+ "2) Deny account \n"
			+ "3) Go back");
		String choice = scanner.next();
		switch(choice) {
		case "1":
			approved = "APPROVED";
			break;
		case "2":
			approved = "DENIED";
			break;
		case "3":
			MenuController menuController = new MenuController();
			menuController.menus();
		default: 
			System.out.println("Choice not valid");
			return;
		}
		accountService.updateAccountInfo(num, approved);
		return;
	
}

	public void newAccount() {
		// TODO Auto-generated method stub
		logger.debug("opening an account");
		boolean checked = false;
		System.out.println("What is your customer ID?");
		int customerId = scanner.nextInt();
		System.out.println("What will the beginning balance be? ");
		double begBalance = scanner.nextDouble();
		checked = accountService.validateNumber(begBalance);
		if(checked == true)
			accountService.openAccount(begBalance, customerId);
		else
			System.out.println("Cannot give an account a negative balance");
	
	}
	
	public void deleteAccount() {
		logger.debug("deleting account");
		System.out.println("Please enter the account number");
		int accountId = scanner.nextInt();
		accountService.deleteAccount(accountId);
	}

}

