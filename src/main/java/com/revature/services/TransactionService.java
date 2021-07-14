package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.MenuController;
import com.revature.daos.TransactionDAO;
import com.revature.daos.TransactionDAOImpl;
import com.revature.models.Transaction;
import com.revature.models.Transfer;

public class TransactionService {

	private static Logger logger = LoggerFactory.getLogger(TransactionService.class);
	TransactionDAO transactionDAO = new TransactionDAOImpl();

	public void createWithdrawal(Transaction transaction) {
		// TODO Auto-generated method stub
		logger.debug("creating new withdrawal");
		transactionDAO.createWithdrawal(transaction);
	}

	public void createDeposit(Transaction transaction) {
		// TODO Auto-generated method stub
		logger.debug("creating a deposit");
		transactionDAO.createDeposit(transaction);
	}

	public void createTransfer(Transfer transfer) {
		// TODO Auto-generated method stub
		logger.debug("creating a transfer");
		transactionDAO.createTransfer(transfer);
	}

}
