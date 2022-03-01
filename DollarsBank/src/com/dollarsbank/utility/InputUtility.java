package com.dollarsbank.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtility {
	
	public static boolean checkForNumbers(String testString) {
		char[] chars = testString.toCharArray();
	    for(char c : chars){
	    	if(Character.isDigit(c)){
	    		return true;
	        }
	    }
		return false;
	}
	
	public static boolean checkForSpecialCharaters(String testString) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");
        Matcher matcher = pattern.matcher(testString);
        boolean stringContainsSpecialCharacter = matcher.find();
        if(stringContainsSpecialCharacter)
            return true;
        else    
            return false;
    }
	
	public static boolean checkForMoneyDeposit(String testString) {
		Pattern pattern = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$");
        Matcher matcher = pattern.matcher(testString);
        boolean stringContainsSpecialCharacter = matcher.find();
        if(stringContainsSpecialCharacter)
            return true;
        else    
            return false;
	}
	
	public static boolean checkForLetters(String testString) {
		char[] chars = testString.toCharArray();
		for(char c : chars) {
			if(!Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkForStringLength(String testString) {
		int length = testString.length();
		if (length == 10) return false;
		return true;
	}
	
	public static boolean checkPasswordStringLength(String testString) {
		int length = testString.length();
		if (length < 8) return true;
		return false;
	}
	
	
	
	
	
	
	
	
	
}
