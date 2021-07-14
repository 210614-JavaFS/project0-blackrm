package com.revature.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.AccountController;
import com.revature.controllers.MenuController;
import com.revature.controllers.TransactionController;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

public class UserService {
	
	AccountController accountController = new AccountController();
	TransactionController transactionController = new TransactionController();
	AccountService accountService = new AccountService();
	UserDAO userDAO = new UserDAOImpl();
	MenuController menuController = new MenuController();
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	public User logInUser(String username, String pwd) {
		// TODO Auto-generated method stub
		logger.debug("logging in user " + username);
		User user = new User();
		user = userDAO.logInUser(username, pwd);
		return user;	
	}

	public void customerMenu(String response) {
		// TODO Auto-generated method stub
		while(response.compareTo("5") != 0) {
			switch(response) {
			case "1":
				accountController.newAccount();
				break;
			case "2":
				TransactionController.makeWithdrawal();
				break;
			case "3":
				TransactionController.makeDeposit();
				break;
			case "4":
				TransactionController.makeTransfer();
				break;
			case "5":
				System.out.println("Thank you! Have a nice day!");
				logger.info("customer logging out");
				break;
			default:
				System.out.println("Invalid entry, please try again:  ");
				return;
			}
			menuController.customerMenu();
		}
	}

	public void employeeMenu(String response) {
		// TODO Auto-generated method stub
		while(response.compareTo("5") != 0) {
			switch(response) {
			case "1":
				accountService.viewAllAccounts();
				break;
			case "2":
				accountController.viewAccountData();
				break;
			case "3":
				accountController.viewCustomerData();;
				break;
			case "4":
				accountController.updateAccountData();
				break;
			case "5":
				System.out.println("Thank you! Have a nice day!");
				logger.info("employee logging out");
				break;
			default:
				System.out.println("Invalid entry, please try again:  ");
				return;
			}
			menuController.employeeMenu();
		}
	}

	public void adminMenu(String response) {
		// TODO Auto-generated method stub
		while(response.compareTo("9") != 0) {
			switch(response) {
			case "1":
				accountService.viewAllAccounts();
				break;
			case "2":
				accountController.viewAccountData();
				break;
			case "3":
				accountController.viewCustomerData();
				break;
			case "4":
				accountController.updateAccountData();
				break;
			case "5":
				TransactionController.makeDeposit();
				break;
			case "6":
				TransactionController.makeWithdrawal();
				break;
			case "7":
				TransactionController.makeTransfer();
				break;
			case "8":
				accountController.deleteAccount();
				break;
			case "9":
				System.out.println("Thank you! Have a nice day!");
				logger.info("admin logging out");
				break;
			default:
				System.out.println("Invalid entry, please try again:  ");
				return;
			}
			menuController.adminMenu();
		}
	}

	public String createNewUser(User user) {
		// TODO Auto-generated method stub
		logger.debug("creating a new user");
		ArrayList<User> users = new ArrayList<User>();
		String resp = "";
		users = userDAO.findUserbyUsername(user.getUsername());
		if(users.size() == 0) {
			userDAO.createNewUser(user);
			resp = "Your new login has been created";
			System.out.println(resp);
		}
		else {
			resp = "Login could not be created.  Username already in use";
			System.out.println(resp);
		}
		return resp;
			
	}

}
