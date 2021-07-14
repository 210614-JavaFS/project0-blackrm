package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;

import com.revature.models.Customer;
import utils.JDBCConnection;

public class AccountDAOImpl implements AccountDAO {
	
	static Connection conn = JDBCConnection.makeConnection();
	private static Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);


	@Override
	public Account getAccountInfo(int num) {
		// TODO Auto-generated method stub
		Account account = new Account();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select id, balance, customer_id from bankaccount where id = ?");
			logger.debug("finding account for " + num);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				account.setId(rs.getInt(1));
				account.setBalance(rs.getDouble(2));
				account.setCustomerId(rs.getInt(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("account could not be found", e);
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public ArrayList<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		ArrayList<Account> accounts = new ArrayList<Account>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select id, balance, customer_id, approved from bankaccount");
			logger.debug("finding all accounts");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt(1));
				account.setBalance(rs.getDouble(2));
				account.setCustomerId(rs.getInt(3));
				account.setApproved(rs.getString(4));
				accounts.add(account);
			}
			System.out.println(accounts.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("account could not be found", e);
			e.printStackTrace();
		}
		return accounts;
		
	}

	@Override
	public double viewBalance(int accountId) {
		// TODO Auto-generated method stub
		double balance = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select balance from bankaccount where id = ?");
			logger.debug("retrieving balance of account for " + accountId);
			pstmt.setInt(1, accountId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				balance = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("balance could not be read", e);
			e.printStackTrace();
		}
	return balance;
	}

	@Override
	public void openAccount(double begBalance, int customerId) {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer customer = new Customer();
		customer = customerDAO.getCustomerById(customerId);
		logger.debug("making sure customer exists with id " + customerId);
		if(customer.getUsername() != null){
			try {
				PreparedStatement pstmt = conn.prepareStatement("insert into bankaccount(id, balance, customer_id, approved) values (default, ?,?,'PENDING')");
				logger.debug("opening account");
				pstmt.setDouble(1, begBalance);
				pstmt.setInt(2, customerId);
				int k = pstmt.executeUpdate();
				System.out.println(k + " account added");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error("account could not be opened", e);
				e.printStackTrace();
			}
		}
			else
				System.out.println("Customer did not exist");
		return;
	}

	@Override
	public String deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from bankaccount where id = ?");
			logger.debug("deleting account " + accountId);
			pstmt.setInt(1, accountId);
			int k = pstmt.executeUpdate();
			message = "Account " + accountId + " deleted";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("account could not be deleted", e);
			message = "Account " + accountId + " not successfully deleted";
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String updateAccount(int num, String approved) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement("update bankaccount set approved = ? where id = ?");
			logger.debug("updating account " + num);
			pstmt.setString(1, approved);
			pstmt.setInt(2, num);
			int k = pstmt.executeUpdate();
			message = "Account " + num + " updated";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("balance could not be read", e);
			message = "Account " + num + " not successfully updated";
			e.printStackTrace();
		}
		return message;
	}

}
