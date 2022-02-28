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

	// Create a new Customer Account
	public static void createNewAccount() {
		Scanner input = new Scanner(System.in);
		String customerName = "", address = "", contactNumber = "", password = "", stringTest = "";
		int userID = (int) Math.floor(Math.random() * (999999 - 111111 + 1) + 111111);
		double amount = 0.00, doubleTest = 0.00;
		
		System.out.println("\n");
		ConsolePrinterUtility.detailsHeading();
		
		try {
			// Get and test Customers Full Name
			boolean fullNameCheck = true;
			while(fullNameCheck) {
				System.out.println("Customer Full Name: ");
				stringTest = input.nextLine().trim();
				
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
				stringTest = input.nextLine().trim();
				
				if(stringTest.isBlank()) throw new InvalidInputException("Customer address cannot be blank.");
				else {
					address = stringTest;
					fullAddressCheck = false;
				}
			}
			
			// Get and test Customers Contact Number
			boolean contactNumberCheck = true;
			while(contactNumberCheck) {
				System.out.println("Customer Contact Number: ");
				stringTest = input.nextLine().trim();
				
				if(stringTest.isBlank()) throw new InvalidInputException("Contact number cannot be blank.");
				else if(InputUtility.checkForSpecialCharaters(stringTest)) throw new InvalidInputException("Contact number cannot contain special characters.");
				else if(InputUtility.checkForLetters(stringTest)) throw new InvalidInputException("Contact number cannot contain letters.");
				else if(InputUtility.checkForStringLength(stringTest)) throw new InvalidInputException("Customer contact number must be 10 digits 'XXXXXXXXXX'");
				else {
					contactNumber = stringTest;
					contactNumberCheck = false;
				}
			}
			
			// Get and test Password
			boolean passwordCheck = true;
			while(passwordCheck) {
				System.out.println("Create Password: ");
				stringTest = input.nextLine();
				
				if(stringTest.isBlank()) throw new InvalidInputException("Password cannot be blank.");
				else if(InputUtility.checkPasswordStringLength(stringTest)) throw new InvalidInputException("Password must be 8 characters or longer.");
				else if(!InputUtility.checkForSpecialCharaters(stringTest)) throw new InvalidInputException("Password must contain at least one special character.");
				else if(!InputUtility.checkForNumbers(stringTest)) throw new InvalidInputException("Password must contain at least one number.");
				else {
					password = stringTest;
					passwordCheck = false;
				}
			}
			
			// Get and test Initial Deposit
			boolean depositCheck = true;
			while(depositCheck) {
				System.out.println("Enter Initial Deposit: ");
				stringTest = input.nextLine();
				
				if(stringTest.isBlank()) throw new InvalidInputException("Deposit cannot be blank.");
				else if(InputUtility.checkForSpecialCharaters(stringTest)) throw new InvalidInputException("Deposit cannot contain special characters");
				else if(InputUtility.checkForLetters(stringTest)) throw new InvalidInputException("Deposit cannot contain letters.");
				else {
					doubleTest = Double.parseDouble(stringTest);
					if(doubleTest < 100) throw new InvalidInputException("Inital deposit must be 100 or greater in value.");
					else {
						amount = doubleTest;
						depositCheck = false;
					}
				}
			}
			
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
	
	
	
	// Customer Login
	public static void login() {
		Scanner input = new Scanner(System.in);
		String userID = "", password = "", inputTest = "";
		int counter = 0;
		
		System.out.println("\n");
		ConsolePrinterUtility.loginHeading();
		
		try {
			boolean loginCheck = true;
			
			// Get and test userID login
			while(loginCheck) {
				System.out.println("Enter User ID: ");
				inputTest = input.nextLine();
				
				if(inputTest.isBlank()) throw new InvalidInputException("User ID cannot be blank.");
				else if(inputTest.length() != 6) throw new InvalidInputException("User ID must be 6 digits in length");
				else if(InputUtility.checkForSpecialCharaters(inputTest)) throw new InvalidInputException("User ID does not contain special characters");
				else if(InputUtility.checkForLetters(inputTest)) throw new InvalidInputException("User ID does not contain letters.");
				else {
					userID = inputTest;
					loginCheck = false;
				}
			}
			
			// Reset boolean
			loginCheck = true;
			
			// Get and test password login
			while(loginCheck) {
				
				System.out.println("Enter Password: ");
				inputTest = input.nextLine();
				
				if(inputTest.isBlank()) throw new InvalidInputException("Password cannot be blank.");
				else if(inputTest.length() != 6) throw new InvalidInputException("Password must be at least 8 characters in length.");
				else {
					password = inputTest;
					loginCheck = false;
				}
			}
			
			// Check customers for correct login
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void userAccounts() {
		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		System.out.println("\n");
		ConsolePrinterUtility.customerHeading();
		
		do {
			ConsolePrinterUtility.mainMenu();
			userInput = input.nextLine().trim();
			switch(userInput) {
				case "1":
					deposit();
					break;
				case "2":
					withdraw();
					break;
				case "3": 
					transfer();
					break;
				case "4": 
					recentTransactions();
					break;
				case "5":
					customerInfo();
					break;
				case "6": signout();
					break;
				default:
					System.out.println("Input is invalid. Please enter 1, 2, or 3 only.");
			}
		} while(!userInput.equals("6"));
		
		
		
	}
	
	
	public static void deposit() {
		
		
		System.out.println("\n");
		ConsolePrinterUtility.depositHeading();
		
	}
	
	
	public static void withdraw() {
		
		
		System.out.println("\n");
		ConsolePrinterUtility.withdrawHeading();
		
	}
	
	
	public static void transfer() {
		
		
		System.out.println("\n");
		ConsolePrinterUtility.transferHeading();
		
	}
	
	public static void recentTransactions() {
		
		
		System.out.println("\n");
		ConsolePrinterUtility.transactionsHeading();
		
	}
	
	public static void customerInfo() {
		
		
		System.out.println("\n");
		ConsolePrinterUtility.customerHeading();
		
	}
	
	public static void signout() {
		System.out.println("\n");
		ConsolePrinterUtility.signoutHeading();
		System.out.println("\n");
	}
	
	
	
	
	
	
	
	
	
	
	
}
