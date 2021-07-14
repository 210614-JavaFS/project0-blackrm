package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Transaction;
import com.revature.models.Transfer;

import utils.JDBCConnection;

public class TransactionDAOImpl implements TransactionDAO {
	
	static Connection conn = JDBCConnection.makeConnection();
	private static Logger logger = LoggerFactory.getLogger(TransactionDAOImpl.class);
	AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public void createWithdrawal(Transaction transaction) {
		// TODO Auto-generated method stub
		double balance = accountDAO.viewBalance(transaction.getAccount_id());
		if(balance < transaction.getAmount())
			System.out.println("Insufficient funds for transaction");
		else {
			try {
				PreparedStatement pstmt = conn.prepareStatement("insert into "
						+ "banktransaction(id, amount, trans_type, account_id, customer_id) values (default, ?,?,?,?)");
				logger.debug("creating withdrawal");
				pstmt.setDouble(1, transaction.getAmount());
				pstmt.setString(2, transaction.getTrans_type());
				pstmt.setInt(3, transaction.getAccount_id());
				pstmt.setInt(4, transaction.getCustomerId());
				int k = pstmt.executeUpdate();
				System.out.println(k + " withdrawal added");
				
				double newbalance = balance - transaction.getAmount();
				PreparedStatement pstmt2 = conn.prepareStatement("update bankaccount set balance = ? where id = ?");
				logger.debug("adjusting balance");
				pstmt2.setDouble(1, newbalance);
				pstmt2.setInt(2, transaction.getAccount_id());
				pstmt2.executeUpdate();
				System.out.println("balance updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error("withdrawal could not be created", e);
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createDeposit(Transaction transaction) {
		// TODO Auto-generated method stub
		double balance = accountDAO.viewBalance(transaction.getAccount_id());
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into "
					+ "banktransaction(id, amount, trans_type, account_id, customer_id) values (default, ?,?,?,?)");			logger.debug("creating deposit");
			
			logger.debug("creating a deposit");
			pstmt.setDouble(1, transaction.getAmount());
			pstmt.setString(2, transaction.getTrans_type());
			pstmt.setInt(3, transaction.getAccount_id());
			pstmt.setInt(4, transaction.getCustomerId());
			int k = pstmt.executeUpdate();
			System.out.println(k + " deposit added");
				
			double newbalance = balance + transaction.getAmount();
			PreparedStatement pstmt2 = conn.prepareStatement("update bankaccount set balance = ? where id = ?");
			logger.debug("adjusting balance");
			pstmt2.setDouble(1, newbalance);
			pstmt2.setInt(2, transaction.getAccount_id());
			pstmt2.executeUpdate();
			System.out.println("balance updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error("deposit could not be created", e);
				e.printStackTrace();
			}
		
	}

	@Override
	public void createTransfer(Transfer transfer) {
		// TODO Auto-generated method stub
		double balance = accountDAO.viewBalance(transfer.getStartAccount());
		double balance2 = accountDAO.viewBalance(transfer.getDestAccount());
		if(balance < transfer.getAmount())
			System.out.println("Insufficient funds for transfer");
		else {
			try {
				PreparedStatement pstmt = conn.prepareStatement("insert into "
						+ "banktransfer(id, customer_id, amount, start_account, dest_account) values (default, ?,?,?,?)");
				logger.debug("creating transfer");
				pstmt.setInt(1, transfer.getCustomerId());
				pstmt.setDouble(2, transfer.getAmount());
				pstmt.setInt(3, transfer.getStartAccount());
				pstmt.setInt(4, transfer.getDestAccount());
				int k = pstmt.executeUpdate();
				System.out.println(k + " transfer added");
				
				double newbalance = balance - transfer.getAmount();
				PreparedStatement pstmt2 = conn.prepareStatement("update bankaccount set balance = ? where id = ?");
				logger.debug("adjusting balance");
				pstmt2.setDouble(1, newbalance);
				pstmt2.setInt(2, transfer.getStartAccount());
				pstmt2.executeUpdate();
				System.out.println("balance updated");
				
				double newbalance2 = balance2 + transfer.getAmount();
				PreparedStatement pstmt3 = conn.prepareStatement("update bankaccount set balance = ? where id = ?");
				logger.debug("adjusting balance");
				pstmt3.setDouble(1, newbalance2);
				pstmt3.setInt(2, transfer.getDestAccount());
				pstmt3.executeUpdate();
				System.out.println("balance updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error("transfer could not be created", e);
				e.printStackTrace();
			}
		}
		
	}

}
