package com.dollarsbank.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.exceptions.InvalidInputException;
import com.dollarsbank.model.CheckingAccount;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.InputUtility;

public class DollarsBankController {
	
	// Store accounts
	static List<Customer> Customers = new ArrayList<Customer>();
	static List<CheckingAccount> CheckingAccounts = new ArrayList<CheckingAccount>();
	static List<SavingsAccount> SavingsAccounts = new ArrayList<SavingsAccount>();

	public static void createNewAccount() {
		Scanner input = new Scanner(System.in);
		String customerName, address, contactNumber, password, stringTest = "";
		int userID = (int) Math.floor(Math.random() * (999999 - 111111 + 1) + 111111);
		double amount, doubleTest = 0.00;
		
		try {
			// Get and test Customers Full Name
			boolean fullNameCheck = true;
			while(fullNameCheck) {
				System.out.println("Customer Full Name: ");
				stringTest = input.nextLine();
				
				if(stringTest.isBlank()) throw new InvalidInputException("Name cannot be blank.");
				else if(InputUtility.checkForNumbers(stringTest)) throw new InvalidInputException("Name cannot contain numbers");
				else if(InputUtility.checkForSpecialCharaters(stringTest)) throw new InvalidInputException("Name cannot contain special characters");
				else {
					customerName = stringTest;
					fullNameCheck = false;
				}
			}
			
			// Get and test Customers Full Address
			boolean fullAddressCheck = true;
			while(fullAddressCheck) {
				System.out.println("Customer Full Address: ");
				stringTest = input.nextLine();
				
				if(stringTest.isBlank()) throw new InvalidInputException("Name cannot be blank.");
				else {
					address = stringTest;
					fullAddressCheck = false;
				}
			}
			
			// Get and test Customers Contact Number
			System.out.println("Customer Contact Number: ");
			contactNumber = input.nextLine();
			
			System.out.println("Create Password: ");
			password = input.nextLine();
			
			System.out.println("Enter Initial Deposit: ");
			amount = input.nextDouble();
			
			// Create New User
			Customer newCustomer = new Customer(userID, customerName, address, contactNumber, password);
			CheckingAccount newCheckingAccount = new CheckingAccount(amount, userID);
			SavingsAccount newSavingsAccount = new SavingsAccount(0, userID);
			
			// Store Accounts
			Customers.add(newCustomer);
			CheckingAccounts.add(newCheckingAccount);
			SavingsAccounts.add(newSavingsAccount);
			
			ConsolePrinterUtility.accountCreadtedHeading();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void login() {
		Scanner input = new Scanner(System.in);
		String userID, password;
		
		try {
			System.out.println("Enter User ID: ");
			userID = input.nextLine();
			
			System.out.println("Enter Password: ");
			password = input.nextLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
