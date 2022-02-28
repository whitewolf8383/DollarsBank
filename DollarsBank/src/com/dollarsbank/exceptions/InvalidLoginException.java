package com.dollarsbank.exceptions;

public class InvalidLoginException extends Exception {
	
	private static final long serialVersionUID = -8246078249156318926L;

	public InvalidLoginException(String e) {
		super(e);
	}
}
