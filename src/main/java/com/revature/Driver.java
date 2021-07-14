package com.revature;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.MenuController;

import utils.JDBCConnection;

public class Driver {

	private static Logger logger = LoggerFactory.getLogger(Driver.class);
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.info("Application started");
		System.out.println("RB Bank");
		System.out.println("=======");
		System.out.println();
		
		
		MenuController menuController = new MenuController();
		
		System.out.println("Would you like to create a login: Y or N");
		String choice = scanner.next();
		choice = choice.toUpperCase();
		if(choice.compareTo("Y") == 0)
			menuController.createLogin();
		
		menuController.logIn();
		
		System.out.println("Thank you for banking with RB Bank today!");
		System.out.println("Have a great day!");

	}

}
