package com.dollarsbank.model;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = -977293727194714630L;
	
	// Attributes
	private int userID;
	private String customerName;
	private String address;
	private String contactNumber;
	private String password;
	
	// Constructor
	public Customer(int userID, String customerName, String address, String contactNumber, String password) {
		super();
		this.userID = userID;
		this.customerName = customerName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.password = password;
	}
	
	// Getters and Setters
	public int getUserID() {
		return userID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// To String
	@Override
	public String toString() {
		return "Customer [userID=" + userID + ", customerName=" + customerName + ", address=" + address
				+ ", contactNumber=" + contactNumber + "]";
	}
	
}
