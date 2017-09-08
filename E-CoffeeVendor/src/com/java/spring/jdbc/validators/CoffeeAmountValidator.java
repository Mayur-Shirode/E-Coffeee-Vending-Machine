package com.java.spring.jdbc.validators;

public class CoffeeAmountValidator {
	
	public static boolean coffeeAmountValidtor(String coffeeType, int amount){
		
		if(coffeeType.equalsIgnoreCase("white") && amount == 10){
			return true;
		}
		else if(coffeeType.equalsIgnoreCase("black") && amount == 6){
			return true;
		}
		else {
			return false;
		}
	}

}
