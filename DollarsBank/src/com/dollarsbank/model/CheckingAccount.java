package com.dollarsbank.model;

import java.io.Serializable;

public class CheckingAccount implements Serializable {
	
	private static final long serialVersionUID = 658923796762857015L;
	
	// Attributes
	private int accountNumber;
	private int userID;
	private double amount;
		
	public CheckingAccount(double amount, int userID) {
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
		return "CheckingAccount [userID= " + userID + ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
}
