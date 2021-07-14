package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.User;
import com.revature.services.UserService;

public class MenuController {
	
	private static Logger logger = LoggerFactory.getLogger(MenuController.class);
	private static Scanner scanner = new Scanner(System.in);
	public static User myUser = new User();
	private static UserService userService = new UserService();

	public void logIn() {
		logger.debug("logging the user in and making sure they have been authenticated");
		System.out.println("Please log in: Enter user name: ");
		String username = scanner.next();
		System.out.println("Enter user password:  ");
		String pwd = scanner.next();
		myUser = userService.logInUser(username, pwd);
		if(myUser.getUsername() != null)
			menus();
		else
			System.out.println("Your login was unsuccessful");
		return;
	}
	
	public void menus() {
		if(myUser.getRole().compareTo("ADMIN") == 0)
			adminMenu();
		else if(myUser.getRole().compareTo("CUSTOMER") == 0)
			customerMenu();
		else if(myUser.getRole().compareTo("EMPLOYEE") == 0)
			employeeMenu();
		return;
	}

	public void employeeMenu() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		System.out.println("How can we help you today? \n"
				+ "1) View all accounts \n"
				+ "2) View data for an account \n"
				+ "3) View customer data \n"
				+ "4) Approve or deny an account \n"
				+ "5) Exit application");
		String response = scanner.next();
		if(response == "5")
			return;
		else
			userService.employeeMenu(response);
		return;
	}

	public void customerMenu() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to RB Bank.");
		System.out.println("How can we help you today? \n"
				+ "1) Register for an Account \n"
				+ "2) Make a Withdrawal \n"
				+ "3) Make a Deposit \n"
				+ "4) Make a Transfer \n"
				+ "5) Exit application");
		String response = scanner.next();
		System.out.println(response);
		if(response.compareTo("5") != 0)
			userService.customerMenu(response);
		return;
	}

	public void adminMenu() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		System.out.println("How can we help you today? \n"
				+ "1) View all accounts \n"
				+ "2) View data for an account \n"
				+ "3) View customer data \n"
				+ "4) Approve or deny an account \n"
				+ "5) Making a deposit \n"
				+ "6) Making a withdrawal \n"
				+ "7) Making a transfer \n"
				+ "8) Cancel account \n"
				+ "9) Exit application");
		String response = scanner.next();
		if(response.compareTo("9") != 0)
			userService.adminMenu(response);
		return;
	}

	public void createLogin() {
		// TODO Auto-generated method stub
		logger.debug("creating a new user");
		String message = "";
		System.out.println("Enter user name: ");
		String username = scanner.next();
		System.out.println("Enter user password:  ");
		String pwd = scanner.next();
		User user = new User();
		user.setUsername(username);
		user.setPassword(pwd);
		user.setRole("CUSTOMER");
		message = userService.createNewUser(user);
		System.out.println(message);
		if(message.compareTo("Login could not be created.  Username already in use") == 0) {
			System.out.println(message);
			return;
		}
		System.out.println("Your user account has been created");
		System.out.println("Would you like to log in?  ");
		return;
	}
		
	}

