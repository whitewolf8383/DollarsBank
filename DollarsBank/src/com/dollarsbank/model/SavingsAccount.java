package com.dollarsbank.model;

public class SavingsAccount {
	
	// Attributes
	private int accountNumber;
	private int userID;
	private double amount;
	
	public SavingsAccount(double amount, int userID) {
		super();
		this.accountNumber = (int) Math.floor(Math.random() * (999999999 - 111111111 + 1) + 111111111);
		this.userID = userID;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public int getUserID() {
		return userID;
	}

	@Override
	public String toString() {
		return "SavingsAccount [userID=" + userID + "accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
	
}
