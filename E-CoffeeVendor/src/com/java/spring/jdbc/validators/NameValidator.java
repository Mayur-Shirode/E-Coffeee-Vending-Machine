package com.java.spring.jdbc.validators;

public class NameValidator {
	
	public static boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}

}
