package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Transaction;
import com.revature.models.Transfer;
import com.revature.services.AccountService;
import com.revature.services.TransactionService;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;    

public class TransactionController {
	
	private static Logger logger = LoggerFactory.getLogger(TransactionController.class);
	private static Scanner scanner = new Scanner(System.in);
	private static AccountService accountService = new AccountService();
	private static Transaction transaction = new Transaction();
	private static Transfer transfer = new Transfer();
	private static TransactionService transactionService = new TransactionService();

	public static void makeWithdrawal() {
		// TODO Auto-generated method stub
		logger.debug("making a withdrawal");
		boolean checked = false;
		System.out.println("Please enter the account number:  ");
		int accountId = scanner.nextInt();
		System.out.println("Please enter the customer Id:  ");
		int customerId = scanner.nextInt();
		System.out.println("How much would you like to withdraw?  ");
		double amt = scanner.nextDouble();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		String transDate = formatter.format(now);
		checked = accountService.validateNumber(amt);
		transaction.setAccount_id(accountId);
		transaction.setAmount(amt);
		transaction.setCustomerId(customerId);
		transaction.setTrans_date(transDate);
		transaction.setTrans_type("WITHDRAWAL");
		if(checked == true) {
			transactionService.createWithdrawal(transaction);
			accountService.viewBalance(accountId);
		}
		else
			System.out.println("Cannot withdraw a negative number");
		return;
	}

	public static void makeDeposit() {
		// TODO Auto-generated method stub
		logger.debug("making a deposit");
		System.out.println("Please enter the account number:  ");
		int accountId = scanner.nextInt();
		System.out.println("Please enter the customer Id:  ");
		int customerId = scanner.nextInt();
		System.out.println("How much would you like to deposit?  ");
		double amt = scanner.nextDouble();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		String transDate = formatter.format(now);
		transaction.setAccount_id(accountId);
		transaction.setAmount(amt);
		transaction.setCustomerId(customerId);
		transaction.setTrans_date(transDate);
		transaction.setTrans_type("DEPOSIT");
		boolean checked = accountService.validateNumber(amt);
		if(checked == true) {
			transactionService.createDeposit(transaction);
			accountService.viewBalance(accountId);
		}
		else
			System.out.println("Cannot deposit a negative number");
		return;
	}

	public static void makeTransfer() {
		// TODO Auto-generated method stub
		logger.debug("making a transfer");
		System.out.println("Please enter the account number of the account "
				+ "you will be transferring the money from:  ");
		int startId = scanner.nextInt();
		System.out.println("Please enter the account number of the account "
				+ "you will be transferring the money to:  ");
		int destId = scanner.nextInt();
		System.out.println("Please enter the customer Id:  ");
		int customerId = scanner.nextInt();
		System.out.println("How much would you like to transfer?  ");
		double amt = scanner.nextDouble();
		transfer.setAmount(amt);
		transfer.setCustomerId(customerId);
		transfer.setDestAccount(destId);
		transfer.setStartAccount(startId);
		boolean checked = accountService.validateNumber(amt);
		if(checked == true) {
			transactionService.createTransfer(transfer);
			accountService.viewBalance(startId);
			accountService.viewBalance(destId);
		}
		else
			System.out.println("Cannot transfer a negative number");
		return;
	}

}
