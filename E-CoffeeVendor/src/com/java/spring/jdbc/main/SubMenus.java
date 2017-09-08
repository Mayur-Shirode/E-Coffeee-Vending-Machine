package com.java.spring.jdbc.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.java.spring.jdbc.bean.MaterialDetails;
import com.java.spring.jdbc.dta.DatabaseAccessor;

public class SubMenus {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void getMaterialStatus() throws SQLException{
		
		System.out.println("--------------------------Material Status-------------------------- \n");
		
		MaterialDetails md = new MaterialDetails();
		md = DatabaseAccessor.retrieveMaterials();
		if(md != null){
			
			System.out.println("Avaliable coffee powder : " + md.getCoffee() + " gms");
			System.out.println("Avaliable sugar  : " + md.getSugar() + " gms");
			System.out.println("Avaliable creamer : " + md.getCreamer() + " ml ");
			System.out.println("-------------------------------------------------------------------\n");
			
		}
		else {
			
			System.out.println("The storage is empty....... Please add the required materials");
		}
		

	}
	
	public static void getTransactionStatus() throws SQLException{
		
		int whiteQnt = DatabaseAccessor.getQuantityWhiteCoffee();
		int whiteAmt = DatabaseAccessor.getSumWhiteCoffee();
		int blackQnt = DatabaseAccessor.getQuantityBlackCoffee();
		int blackAmt = DatabaseAccessor.getSumBlackCoffee();
		int total_qty = whiteQnt + blackQnt;
		int total_amt = whiteAmt + blackAmt;
		
		System.out.println("--------------------------Transaction Report-------------------------- \n");
		System.out.println("Sr No.\t Type\t Quantity\t Amount \n");
		System.out.println("-------------------------------------------------");
		System.out.println("1 \t White \t "+ whiteQnt +" \t\t" + whiteAmt);
		System.out.println("2 \t Black \t "+ blackQnt +" \t\t" + blackAmt);
		System.out.println("--------------------------------------------------\n");
		System.out.println("Total Coffee \t" + total_qty + "\t" + total_amt);
		System.out.println("-------------------------------------------------------------------------\n");
		
	}

	public static void orderCoffee(String coffeeType ) throws SQLException, ParseException{
		
		
		String ch = "Y";
		while(ch.equalsIgnoreCase("Y")){
			System.out.println("-------------------------Select a Payment Type-------------------------\n");
			System.out.println("          1. Cash   ");
			System.out.println("          2. Credit Card  ");
			System.out.println("          3. Debit Card   \n ");
			System.out.println("-----------------------------------------------------------------------\n");
			System.out.println("Enter your choice!");
			
			int choice = sc.nextInt();
			
			
				switch(choice){
				
				case 1 : 
					Payment.cashPayment(coffeeType);
					ch = "N";
					break;
				case 2 :
					Payment.creditCardPayment(coffeeType);
					ch = "N";
					break;
				case 3 :
					Payment.debitCardPayment(coffeeType);
					ch = "N";
					break;
				default :
					System.out.println("Please enter a valid choice of 1-3 only  ");
			}
			
				ch = "N";
		}
	}

	
}
