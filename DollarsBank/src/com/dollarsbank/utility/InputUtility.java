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
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(testString);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if(isStringContainsSpecialCharacter)
            return true;
        else    
            return false;
    }
	
}
