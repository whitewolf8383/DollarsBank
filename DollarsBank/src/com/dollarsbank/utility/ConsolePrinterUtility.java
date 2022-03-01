package com.dollarsbank.utility;

public class ConsolePrinterUtility {
	
	// Headings
	public static void welcomeHeading() {
		System.out.println(ColorsUtility.BLUE + "+---------------------------+");
		System.out.println("| DOLLARSBANK Welcomes You! |");
		System.out.println("+---------------------------+" + ColorsUtility.RESET);
	}
	
	public static void detailsHeading() {
		System.out.println(ColorsUtility.BLUE + "+-------------------------------+");
		System.out.println("| Enter Details For New Account |");
		System.out.println("+-------------------------------+" + ColorsUtility.RESET);
	}
	
	public static void loginHeading() {
		System.out.println(ColorsUtility.BLUE + "+---------------------+");
		System.out.println("| Enter Login Details |");
		System.out.println("+---------------------+" + ColorsUtility.RESET);
	}
	
	public static void customerHeading() {
		System.out.println(ColorsUtility.BLUE + "+---------------------+");
		System.out.println("| WELCOME Customer!!! |");
		System.out.println("+---------------------+" + ColorsUtility.RESET);
	}
	
	public static void depositHeading() {
		System.out.println(ColorsUtility.BLUE + "+---------+");
		System.out.println("| Deposit |");
		System.out.println("+---------+" + ColorsUtility.RESET);
	}
	
	public static void withdrawHeading() {
		System.out.println(ColorsUtility.BLUE + "+----------+");
		System.out.println("| Withdraw |");
		System.out.println("+----------+" + ColorsUtility.RESET);
	}
	
	public static void transferHeading() {
		System.out.println(ColorsUtility.BLUE + "+----------+");
		System.out.println("| Transfer |");
		System.out.println("+----------+" + ColorsUtility.RESET);
	}
	
	public static void transactionsHeading() {
		System.out.println(ColorsUtility.BLUE + "+----------------------+");
		System.out.println("| Recent Transactions: |");
		System.out.println("+----------------------+" + ColorsUtility.RESET);
	}
	
	public static void customerInfoHeading() {
		System.out.println(ColorsUtility.BLUE + "+----------------------+");
		System.out.println("| Customer Information |");
		System.out.println("+----------------------+" + ColorsUtility.RESET);
	}
	
	public static void signoutHeading() {
		System.out.println(ColorsUtility.BLUE + "+-----------------------+");
		System.out.println("| Signed Out, Thank You |");
		System.out.println("+-----------------------+" + ColorsUtility.RESET);
	}
	
	public static void accountCreadtedHeading() {
		System.out.println(ColorsUtility.GREEN + "+--------------------------+");
		System.out.println("| Account has been created |");
		System.out.println("+--------------------------+" + ColorsUtility.RESET);
	}
	
	public static void mainMenu() {
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	
	public static void customerMenu() {
		System.out.println("1. Deposite Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Customer Information / Account Balances");
		System.out.println("6. Sign Out");
	}
	
	public static void exitHeading() {
		System.out.println(ColorsUtility.BLUE + "+-----------------------------------------------+");
		System.out.println("| Now Exiting, Thank You for using Dollars Bank! |");
		System.out.println("+-----------------------------------------------+" + ColorsUtility.RESET);
	}
	
}
