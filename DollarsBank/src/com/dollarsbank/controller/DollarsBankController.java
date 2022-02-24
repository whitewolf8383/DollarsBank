package com.dollarsbank.controller;
import java.util.Scanner;

import com.dollarsbank.model.CheckingAccount;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class DollarsBankController {

	public void createNewAccount() {
		Scanner input = new Scanner(System.in);
		String customerName, address, contactNumber, password;
		int userID = (int) Math.floor(Math.random() * (999999 - 111111 + 1) + 111111);
		double amount;
		
		try {
			System.out.println("Customer Full Name: ");
			customerName = input.nextLine();
			
			System.out.println("Customer Full Address: ");
			address = input.nextLine();
			
			System.out.println("Customer Contact Number: ");
			contactNumber = input.nextLine();
			
			System.out.println("Create Password: ");
			password = input.nextLine();
			
			System.out.println("Enter Initial Deposit: ");
			amount = input.nextDouble();
			
			// Create New User
			new Customer(userID, customerName, address, contactNumber, password);
			new CheckingAccount(amount, userID);
			new SavingsAccount(0, userID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			input.close();
		}
	}
	
	public void login() {
		Scanner input = new Scanner(System.in);
		String userID, password;
		
		try {
			System.out.println("Enter User ID: ");
			userID = input.nextLine();
			
			System.out.println("Enter Password: ");
			password = input.nextLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
