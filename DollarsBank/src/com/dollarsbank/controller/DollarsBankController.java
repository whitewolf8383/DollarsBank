package com.dollarsbank.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.exceptions.InvalidInputException;
import com.dollarsbank.model.CheckingAccount;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.model.Transaction;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.InputUtility;

public class DollarsBankController {
	
	// Store accounts
	static List<Customer> Customers = new ArrayList<Customer>();
	static List<CheckingAccount> CheckingAccounts = new ArrayList<CheckingAccount>();
	static List<SavingsAccount> SavingsAccounts = new ArrayList<SavingsAccount>();
	static List<Transaction> Transactions = new ArrayList<Transaction>(); 

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
				else if(!InputUtility.checkForMoneyDeposit(stringTest)) throw new InvalidInputException("Deposit cannot contain special characters or letters");
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
			Transaction newTransaction = new Transaction(String.valueOf(userID), "New account created with inital deposit", amount);
			
			// Store Accounts
			Customers.add(newCustomer);
			CheckingAccounts.add(newCheckingAccount);
			SavingsAccounts.add(newSavingsAccount);
			Transactions.add(newTransaction);
			
			System.out.println("New customer created with ID: " + userID);
			
			ConsolePrinterUtility.accountCreadtedHeading();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// Customer Login
	public static void login() {
		Scanner input = new Scanner(System.in);
		String userID = "", password = "", inputTest = "";
		
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
				else {
					password = inputTest;
					loginCheck = false;
				}
			}
			
			// Check customers for correct login
			for(Customer customer : Customers) {
				if((customer.getUserID() == (Integer.parseInt(userID))) && (customer.getPassword().equals(password))) {
					
					Scanner customerInput = new Scanner(System.in);
					String userInput = "";
					
					System.out.println("\n");
					ConsolePrinterUtility.customerHeading();
					
					
					do {
						ConsolePrinterUtility.customerMenu();
						System.out.println("\n");
						System.out.println("Enter Choice (1, 2, 3, 4, 5, 6) :");
						userInput = customerInput.nextLine().trim();
						System.out.println("\n");
						switch(userInput) {
							case "1":
								deposit(userID);
								break;
							case "2":
								withdraw(userID);
								break;
							case "3": 
								transfer(userID);
								break;
							case "4": 
								recentTransactions(userID);
								break;
							case "5":
								customerInfo(userID);
								break;
							case "6": signout();
								break;
							default:
								System.out.println("Input is invalid. Please enter 1, 2, 3, 4, 5, or 6 only.");
						}
					} while(!userInput.equals("6"));
					
					
				} else if((customer.getUserID() == (Integer.parseInt(userID))) && !(customer.getPassword().equals(password))) {
					System.out.println(ColorsUtility.RED + "Invalid Credentials. Try Again!" + ColorsUtility.RESET + "\n");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void deposit(String userID) throws InvalidInputException {
		Scanner customerInput = new Scanner(System.in);
		String userInput = "", depositTest = "";
		double depositAmount = 0.00;
		
		System.out.println("\n");
		ConsolePrinterUtility.depositHeading();
		do {
			System.out.println("Which account would you like to deposit to?");
			System.out.println("1. Checking");
			System.out.println("2. Savings");
			System.out.println("3. Exit Deposit");
			userInput = customerInput.nextLine().trim();
			System.out.println("\n");
			
			switch(userInput) {
				case "1":
					System.out.println("Enter amount to deposit to Checking");
					depositTest = customerInput.nextLine();
					
					if(depositTest.isBlank()) throw new InvalidInputException("Deposit cannot be blank.");
					else if(!InputUtility.checkForMoneyDeposit(depositTest)) throw new InvalidInputException("Deposit cannot contain special characters or letters");
					else {
						depositAmount = Double.parseDouble(depositTest);
						for(CheckingAccount checkingAccount : CheckingAccounts) {
							if(checkingAccount.getUserID() == (Integer.parseInt(userID))) {
								checkingAccount.setAmount( (checkingAccount.getAmount() + depositAmount) );
								Transaction newTransaction = new Transaction(userID, "Deposited into checking account", depositAmount);
								Transactions.add(newTransaction);
								System.out.println("Successfully deposited into checking account \n.");
							}
						}
					}
					break;
					
				case "2":
					System.out.println("Enter amount to deposit to Savings");
					depositTest = customerInput.nextLine();
					
					if(depositTest.isBlank()) throw new InvalidInputException("Deposit cannot be blank.");
					else if(!InputUtility.checkForMoneyDeposit(depositTest)) throw new InvalidInputException("Deposit cannot contain special characters or letters");
					else {
						depositAmount = Double.parseDouble(depositTest);
						for(SavingsAccount savingsAccount : SavingsAccounts) {
							if(savingsAccount.getUserID() == (Integer.parseInt(userID))) {
								savingsAccount.setAmount( (savingsAccount.getAmount() + depositAmount) );
								Transaction newTransaction = new Transaction(userID, "Deposited into savings account", depositAmount);
								Transactions.add(newTransaction);
								System.out.println("Successfully deposited into savings account \n.");
							}
						}
					}
					break;
					
				case "3": break;
				default:
					System.out.println("Input is invalid. Please enter 1, 2, or 3 only.");
			}
				
		} while(!userInput.equals("3"));
	}
	
	
	public static void withdraw(String userID) throws InvalidInputException {
		Scanner customerInput = new Scanner(System.in);
		String userInput = "", withdrawTest = "";
		double withdrawAmount = 0.00;
		
		System.out.println("\n");
		ConsolePrinterUtility.withdrawHeading();
		do {
			System.out.println("Which account would you like to withdraw from?");
			System.out.println("1. Checking");
			System.out.println("2. Savings");
			System.out.println("3. Exit Withdraw");
			userInput = customerInput.nextLine().trim();
			System.out.println("\n");
			
			switch(userInput) {
				case "1":
					System.out.println("Enter amount to withdraw from Checking");
					withdrawTest = customerInput.nextLine();
					
					if(withdrawTest.isBlank()) throw new InvalidInputException("Amount cannot be blank.");
					else if(!InputUtility.checkForMoneyDeposit(withdrawTest)) throw new InvalidInputException("Amount cannot contain special characters or letters");
					else {
						withdrawAmount = Double.parseDouble(withdrawTest);
						for(CheckingAccount checkingAccount : CheckingAccounts) {
							if(checkingAccount.getUserID() == (Integer.parseInt(userID))) {
								if((checkingAccount.getAmount() - withdrawAmount) < 0) throw new InvalidInputException("Withdraw amount is greater than amount available.");
								else checkingAccount.setAmount( (checkingAccount.getAmount() - withdrawAmount) );
								Transaction newTransaction = new Transaction(userID, "Withdraw from checking account", withdrawAmount);
								Transactions.add(newTransaction);
								System.out.println("Successfully withdrew from checking account \n.");
							}
						}
					}
					break;
					
				case "2":
					System.out.println("Enter amount to withdraw from Savings");
					withdrawTest = customerInput.nextLine();
					
					if(withdrawTest.isBlank()) throw new InvalidInputException("Amount cannot be blank.");
					else if(!InputUtility.checkForMoneyDeposit(withdrawTest)) throw new InvalidInputException("Amount cannot contain special characters or letters");
					else {
						withdrawAmount = Double.parseDouble(withdrawTest);
						for(SavingsAccount savingsAccount : SavingsAccounts) {
							if(savingsAccount.getUserID() == (Integer.parseInt(userID))) {
								if((savingsAccount.getAmount() - withdrawAmount) < 0) throw new InvalidInputException("Withdraw amount is greater than amount available.");
								else savingsAccount.setAmount( (savingsAccount.getAmount() - withdrawAmount) );
								Transaction newTransaction = new Transaction(userID, "Withdraw from savings account", withdrawAmount);
								Transactions.add(newTransaction);
								System.out.println("Successfully withdrew from savings account \n.");
							}
						}
					}
					break;
					
				case "3": break;
				default:
					System.out.println("Input is invalid. Please enter 1, 2, or 3 only.");
			}
				
		} while(!userInput.equals("3"));
		
	}
	
	
	public static void transfer(String userID) throws InvalidInputException {
		Scanner customerInput = new Scanner(System.in);
		String userInput = "", transferTest = "";
		double transferAmount = 0.00;
		
		System.out.println("\n");
		ConsolePrinterUtility.transferHeading();
		do {
			System.out.println("Which account would you like to transfer?");
			System.out.println("1. Checking => Savings");
			System.out.println("2. Savings => Checking");
			System.out.println("3. Exit Transfer");
			userInput = customerInput.nextLine().trim();
			System.out.println("\n");
			
			switch(userInput) {
				case "1":
					System.out.println("Enter amount you want to transfer.");
					transferTest = customerInput.nextLine();
					
					if(transferTest.isBlank()) throw new InvalidInputException("Amount cannot be blank.");
					else if(!InputUtility.checkForMoneyDeposit(transferTest)) throw new InvalidInputException("Amount cannot contain special characters or letters");
					else {
						transferAmount = Double.parseDouble(transferTest);
					}
					
					for(CheckingAccount checkingAccount : CheckingAccounts) {
						if(checkingAccount.getUserID() == (Integer.parseInt(userID))) {
							if((checkingAccount.getAmount() - transferAmount) < 0) throw new InvalidInputException("Transfer amount is greater than amount available.");
							else {
								checkingAccount.setAmount( (checkingAccount.getAmount() - transferAmount) );
								for(SavingsAccount savingsAccount : SavingsAccounts) {
									if(savingsAccount.getUserID() == (Integer.parseInt(userID))) {
										savingsAccount.setAmount( (savingsAccount.getAmount() + transferAmount) );
										Transaction newTransaction = new Transaction(userID, "Transfered funds from checking to savings", transferAmount);
										Transactions.add(newTransaction);
										System.out.println("Successfully transfered funds from checking to savings account \n.");
									}
								}
							}
						}
					}
					break;
					
				case "2":
					System.out.println("Enter amount you want to transfer.");
					transferTest = customerInput.nextLine();
					
					if(transferTest.isBlank()) throw new InvalidInputException("Amount cannot be blank.");
					else if(!InputUtility.checkForMoneyDeposit(transferTest)) throw new InvalidInputException("Amount cannot contain special characters or letters");
					else {
						transferAmount = Double.parseDouble(transferTest);
					}
					
					for(SavingsAccount savingsAccount : SavingsAccounts) {
						if(savingsAccount.getUserID() == (Integer.parseInt(userID))) {
							if((savingsAccount.getAmount() - transferAmount) < 0) throw new InvalidInputException("Transfer amount is greater than amount available.");
							else {
								savingsAccount.setAmount( (savingsAccount.getAmount() - transferAmount) );
								for(CheckingAccount checkingAccount : CheckingAccounts) {
									if(checkingAccount.getUserID() == (Integer.parseInt(userID))) {
										checkingAccount.setAmount( (checkingAccount.getAmount() + transferAmount) );
										Transaction newTransaction = new Transaction(userID, "Transfered funds from savings to checking", transferAmount);
										Transactions.add(newTransaction);
										System.out.println("Successfully transfered funds from savings to checking account \n.");
									}
								}
							}
						}
					}
					break;
					
				case "3": break;
				default:
					System.out.println("Input is invalid. Please enter 1, 2, or 3 only.");
			}
				
		} while(!userInput.equals("3"));
	
	}
	
	public static void recentTransactions(String userID) {
		int counter = 0;
		System.out.println("\n");
		ConsolePrinterUtility.transactionsHeading();
		
		for(Transaction transaction : Transactions) {
			if((transaction.getUserID().equals(userID)) && (counter < 5)) {
				System.out.println(transaction.toString());
				counter++;
			}
		}
		
	}
	
	public static void customerInfo(String userID) {
		System.out.println("\n");
		ConsolePrinterUtility.customerInfoHeading();
		for(Customer customer : Customers) {
			if(customer.getUserID() == (Integer.parseInt(userID))) {
				System.out.println(customer.toString());
				break;
			}
		}
		for(CheckingAccount checkingAccount : CheckingAccounts) {
			if(checkingAccount.getUserID() == (Integer.parseInt(userID))) {
				System.out.println(checkingAccount.toString());
				break;
			}
		}
		for(SavingsAccount savingsAccount : SavingsAccounts) {
			if(savingsAccount.getUserID() == (Integer.parseInt(userID))) {
				System.out.println(savingsAccount.toString() + "\n");
				break;
			}
		}
	}
	
	public static void signout() {
		System.out.println("\n");
		ConsolePrinterUtility.signoutHeading();
		System.out.println("\n");
	}
	
	
	
	
	
	
	
	
	
	
	
}
