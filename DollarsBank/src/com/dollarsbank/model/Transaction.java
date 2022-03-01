package com.dollarsbank.model;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 171048141367869761L;
	
	private String userID;
	private String accountAction;
	private double amount;
	private String date;
	
	public Transaction(String userID, String accountAction, double amount) {
		super();
		this.userID = userID;
		this.accountAction = accountAction;
		this.amount = amount;
		this.date = new Date().toString();
	}

	public String getUserID() {
		return userID;
	}

	@Override
	public String toString() {
		return accountAction + " for account " + userID + "\nin the amount of " + amount + " on " + date + "\n";
	}

	
	
}
