package com.collarsbank.application;

import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String selection = "";
		
		ConsolePrinterUtility.welcomeHeading();
		do {
			ConsolePrinterUtility.mainMenu();
			System.out.println("\n");
			System.out.println("Enter Choice (1, 2, 3) :");
			selection = scanner.nextLine().trim();
			switch(selection) {
				case "1":
					DollarsBankController.createNewAccount();
					break;
				case "2":
					DollarsBankController.login();
					break;
				case "3": break;
				default:
					System.out.println("Input is invalid. Please enter 1, 2, or 3 only.");
			}
		} while(!selection.equals("3"));
		scanner.close();
		ConsolePrinterUtility.exitHeading();
	}

}
