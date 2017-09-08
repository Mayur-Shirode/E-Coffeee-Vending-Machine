package com.java.spring.jdbc.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.java.spring.jdbc.dta.DatabaseAccessor;
import com.java.spring.jdbc.dta.DateFormater;
import com.java.spring.jdbc.validators.CoffeeAmountValidator;

public class Payment 
{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void creditCardPayment(String coffeeType) throws SQLException, ParseException{
		
		System.out.println("-------------------------Payment by Credit Card------------------------- \n");
		System.out.println("Please enter a valid card number : ");
		long cardNo = sc.nextLong();
		System.out.println("Enter the Coffee Amount : ");
		int coffeeAmt = sc.nextInt();
		System.out.println("Enter the card validity in MM/yyyy format : ");
		String validity = sc.next();
		if(CoffeeAmountValidator.coffeeAmountValidtor(coffeeType, coffeeAmt)){
			if(DatabaseAccessor.validateCreditCard(cardNo, validity)) {
				if(DatabaseAccessor.addTransactionDetails(coffeeType, "credit", coffeeAmt)){
					printReceipt(coffeeType, coffeeAmt);
				}
				else{
					System.out.println("Sorry your order could not be placed! Please try again later!");
				}	
			}
			else{
				System.out.println("Sorry your credit card is not registered! Please register your card under Master Data Menu and then try again!");
			}
		}
		else {
			System.out.println("Enter the right amount for your coffee - Rs.10 for White and Rs. 6 for Black!");
		}
	}
	
	public static void debitCardPayment(String coffeeType) throws SQLException, ParseException{
		System.out.println("-------------------------Payment by Debit Card------------------------- \n");
		System.out.println("Please enter a valid card number : ");
		long cardNo = sc.nextLong();
		System.out.println("Enter the pin number : ");
		int pin = sc.nextInt();
		System.out.println("Enter the Coffee Amount : ");
		int coffeeAmt = sc.nextInt();
		if(CoffeeAmountValidator.coffeeAmountValidtor(coffeeType, coffeeAmt)){
			if(DatabaseAccessor.validateDebitCard(cardNo, pin, coffeeAmt)){
				if(DatabaseAccessor.addTransactionDetails(coffeeType, "debit", coffeeAmt)){
					printReceipt(coffeeType, coffeeAmt);
				}else{
					System.out.println("Sorry your order could not be placed! Please try again later!");
				}	
			}
			else{
				System.out.println("Sorry your debit card is not registered! Please register your card under Master Data Menu and then try again!");
			}
		}
		else {
			System.out.println("Enter the right amount for your coffee - Rs.10 for White and Rs. 6 for Black!");
		}
	}
	
	public static void cashPayment(String coffeeType) throws SQLException, ParseException{
		
		int totalWhite = 0;
		boolean orderDetails = false;
		
		if(coffeeType.equalsIgnoreCase("white")){
			while(totalWhite != 10){
				
				System.out.println("-------------------------Payment by Cash------------------------- \n");
				System.out.println("Please enter the number of 1 Re. coins : ");
				int rupeeOne = sc.nextInt();
				System.out.println("Please enter the number of 2 Rs. coins : ");
				int rupeeTwo = sc.nextInt();
				System.out.println("Please enter the number of 5 Rs. coins : ");
				int rupeeFive = sc.nextInt();
				
					totalWhite = (rupeeOne * 1) + (rupeeTwo * 2) + (rupeeFive * 5);
					if(totalWhite != 10){
						System.out.println("The total cost of your coffee is Rs. 10! Please enter valid coin details so that your total does not exceed Rs. 10");	
					}
					else{
						
						orderDetails = DatabaseAccessor.addTransactionDetails(coffeeType, "cash", totalWhite);
						if(orderDetails){
							printReceipt(coffeeType, totalWhite);
						}
						else{
							System.out.println("Sorry your order could not be placed at the moment! Please try again later!");
						}
						
					}
				}	
		}
		else if(coffeeType.equalsIgnoreCase("black")){
			while(totalWhite != 6){
				
				System.out.println("-------------------------Payment by Cash------------------------- \n");
				System.out.println("Please enter the number of 1 Re. coins : ");
				int rupeeOne = sc.nextInt();
				System.out.println("Please enter the number of 2 Rs. coins : ");
				int rupeeTwo = sc.nextInt();
				System.out.println("Please enter the number of 5 Rs. coins : ");
				int rupeeFive = sc.nextInt();
				
					totalWhite = (rupeeOne * 1) + (rupeeTwo * 2) + (rupeeFive * 5);
					if(totalWhite != 6){
						System.out.println("The total cost of your coffee is Rs. 6! Please enter valid coin details so that your total does not exceed Rs. 6");	
					}
					else{
						
						orderDetails = DatabaseAccessor.addTransactionDetails(coffeeType, "cash", totalWhite);
						if(orderDetails){
							printReceipt(coffeeType, totalWhite);
						}
						else{
							System.out.println("Sorry your order could not be placed at the moment! Please try again later!");
						}
						
					}
				}	
		}
	}
	
	public static void printReceipt(String coffeeType, int price){
		
		System.out.println("---------------------- E Coffee Receipt---------------------- \n");
		System.out.println("\t\t\t\t\t\t" +DateFormater.todayDate());
		System.out.println("Coffee type : " +coffeeType );
		System.out.println("Price : Rs."+price + "\n ");
		
		System.out.println("------------------ Thank you! Visit Again! ------------------ \n");
	}
}
