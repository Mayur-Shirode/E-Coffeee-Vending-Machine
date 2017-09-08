package com.java.spring.jdbc.validators;

public class NumberValidator {
	
	public static boolean cardNumberValidator(long cardNo){
		
		String numToken="[\\p{Digit}&&[123456789]]+";
		String number = String.valueOf(cardNo);
		boolean validCard;
		if(number.matches(numToken) && number.length() == 10){
			validCard = true;
		}
		else{
			validCard = false;
		}
		
		return validCard;
		
	}
	
public static boolean phoneNumberValidator(long phoneNo){
		
		String numToken="[\\p{Digit}&&[123456789]]+";
		String number = String.valueOf(phoneNo);
		boolean validPhone;
		if(number.matches(numToken) && number.length() == 10){
			validPhone = true;
		}
		else{
			validPhone = false;
		}
		
		return validPhone;
		
	}

public static boolean pinValidator(int pin){
	
	String numToken="[\\p{Digit}&&[123456789]]+";
	String number = String.valueOf(pin);
	boolean validPhone;
	if(number.matches(numToken) && number.length() == 4){
		validPhone = true;
	}
	else{
		validPhone = false;
	}
	
	return validPhone;
	
}

}
