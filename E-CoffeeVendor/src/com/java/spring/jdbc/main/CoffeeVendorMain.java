package com.java.spring.jdbc.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.java.spring.jdbc.dta.DatabaseAccessor;
import com.java.spring.jdbc.dta.DateFormater;
import com.java.spring.jdbc.validators.NameValidator;

public class CoffeeVendorMain {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		
		
		boolean menu = true;
		
		
		while(menu){
				System.out.println("----------------------Welcome to the Coffee Shop---------------------- \n");
				System.out.println("          1. Order a Coffee      ");
				System.out.println("          2. Master Data Preparation   ");
				System.out.println("          3. Maintenance      ");
				System.out.println("          4. Exit      \n");
				System.out.println("---------------------------------------------------------------------- \n");
				System.out.println("Enter an option ");
		
				int menuChoice = sc.nextInt();
				
				switch(menuChoice){
				
					case 1:  orderCoffee();
						break;
					case 2 : try {
						masterDataPrep();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						break;
					case 3: try {
						maintenance();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						break;
					case 4: menu = false;
						System.out.println("***------------------------Program Terminated----------------------***");
						break;
					default : System.out.println("Please enter a valid choice of 1 - 4 only ! ");
					
				}
			}
	}
	
	
	public static void orderCoffee() throws ParseException{
		
		String ch= "Y";
		String coffee = "Y";
		int choice;
		
		while(ch.equalsIgnoreCase("y")){
		System.out.println("----------------------Select a coffee type-------------------------\n");
		System.out.println("          1. White @ Rs.10    ");
		System.out.println("          2. Black @ Rs.6     ");
		System.out.println("          3. Back    \n");
		System.out.println("-------------------------------------------------------------------\n");
		System.out.println("Enter your choice!");
		choice = sc.nextInt();
		
		//while(coffee.equalsIgnoreCase("Y")){
			
			switch(choice){
			
			case 1 :
				try {
					SubMenus.orderCoffee("white");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2 :
				try {
					SubMenus.orderCoffee("black");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3 :
				ch = "N";
				break;
			default :
				System.out.println("Please enter a valid option between 1-3!");
			}
			//coffee = "N";
		//}
		
		//coffee = "N";
			if(ch.equalsIgnoreCase("Y")){
				System.out.println("Do you want to order another coffee ? Enter Y/N");
				ch = sc.next();
			}
		

		}
		
	}
	
	public static void masterDataPrep() throws ParseException, SQLException{
		
		String toggle = "Y";
		int data;
		String inserter = "Y";
		
		while(toggle.equalsIgnoreCase("y")){
			
			System.out.println("----------------------Master Data Perparation---------------------\n");
			System.out.println("          1. Add a credit card      ");
			System.out.println("          2. Add a debit card       ");
			System.out.println("          3. Back      \n ");
			System.out.println("------------------------------------------------------------------\n");
			System.out.println("Enter an option !");
			data = sc.nextInt();
			
			switch(data){
				
			case 1 : 
				while(inserter.equalsIgnoreCase("Y")){
					
					 System.out.println("----------------------Add a credit card---------------------\n");
					 System.out.println("Enter the credit card number : ");
					 long cardNo = sc.nextLong();
					 System.out.println("Enter the card holder name : ");
					 String name = sc.next();
					 System.out.println("Enter the Date of Birth in the DD-MM-YYYY format : ");
					 String dob = sc.next();
					 System.out.println("Enter the address : ");
					 String address = sc.next();
					 sc.nextLine();
					 System.out.println("Enter the city : ");
					 String city = sc.next();
					 sc.nextLine();
					 System.out.println("Enter the state : ");
					 String state = sc.next();
					 sc.nextLine();
					 System.out.println("Enter the country : ");
					 String country = sc.next();
					 System.out.println("Enter the pin/zip code : ");
					 int code = sc.nextInt();
					 System.out.println("Enter a phone number : ");
					 long phNo = sc.nextLong();
					 System.out.println("Enter the credit limit : ");
					 int creditLimit = sc.nextInt();
					 System.out.println("Enter the validity in the format MM/YYYY : ");
					 String validity = sc.next();
					 Date sql_date = DateFormater.formatDOB(dob);
					 
					 if( NameValidator.isAlpha(name) && NameValidator.isAlpha(city) && NameValidator.isAlpha(country) && NameValidator.isAlpha(state)){
						 
						 boolean isInserted = DatabaseAccessor.addCreditCardDetails(cardNo, name, sql_date, address, city, state, country, code, phNo, creditLimit, validity);
						 if(isInserted){
							 System.out.println("------------------------------------------------------------------\n");
							 System.out.println("Credit card Details entered successfully!");
							 System.out.println("Do you wish to add another credit card? Enter Y/N! ");
							 inserter = sc.next();
						 }
						 else{
							 inserter = "N";
						 }
					 }
					 
					 else { 
						  System.out.println("Please enter valid values for all fields!");
						  inserter = "Y";
					 }
				}
				break;
				
			case 2: 
				while(inserter.equalsIgnoreCase("Y")){
					
					 System.out.println("----------------------Add a debit card---------------------\n");
					 System.out.println("Enter the debit card number : ");
					 long cardNo = sc.nextLong();
					 System.out.println("Enter the card holder name : ");
					 String name = sc.next();
					 System.out.println("Enter the Date of Birth in the DD-MMM-YYYY format : ");
					 String dob = sc.next();
					 System.out.println("Enter the address : ");
					 String address = sc.next();
					 sc.nextLine();
					 System.out.println("Enter the city : ");
					 String city = sc.next();
					 sc.nextLine();
					 System.out.println("Enter the state : ");
					 String state = sc.next();
					 sc.nextLine();
					 System.out.println("Enter the country : ");
					 String country = sc.next();
					 System.out.println("Enter the pin/zip code : ");
					 int code = sc.nextInt();
					 System.out.println("Enter a phone number : ");
					 long phNo = sc.nextLong();
					 System.out.println("Enter the account balance : ");
					 double opBal = sc.nextDouble();
					 System.out.println("Enter the card pin number : ");
					 int pin = sc.nextInt();
					 Date sql_date = DateFormater.formatDOB(dob);
					 if(NameValidator.isAlpha(name) && NameValidator.isAlpha(city) && NameValidator.isAlpha(country) && NameValidator.isAlpha(state)){
						 
						 boolean isInserted = DatabaseAccessor.addDebitCardDetails(cardNo, name, sql_date, address, city, state, country, code, phNo, opBal, pin);
						 if(isInserted){
							 System.out.println("------------------------------------------------------------------\n");
							 System.out.println("Debit card Details entered successfully!");
							 System.out.println("Do you wish to add another debit card? Enter Y/N! ");
							 inserter = sc.next();
						 }
						 else{
							 inserter = "N";
						 }
					 }
					 
					 else { 
						  System.out.println("Please enter valid values for all fields!");
						  inserter = "Y";
					 }
			
				}
				break;
				
			case 3 : 
				toggle = "N";
				break;
				default : 
					System.out.println("Please enter a valid value! Enter options between 1-3 ");
			}	
		}	
	}
	
	public static void maintenance() throws SQLException{
		
		String toggle = "Y";
		int data;
		String maintain = "Y";
		int report ;
		
		while(toggle.equalsIgnoreCase("y")){
			
			System.out.println("---------------------------Maintenance----------------------------\n");
			System.out.println("          1. Add materials      ");
			System.out.println("          2. Reports      ");
			System.out.println("          3. Back        \n ");
			System.out.println("------------------------------------------------------------------\n");
			System.out.println("Enter an option !");
			data = sc.nextInt();
			
			switch(data) {
			
			case 1 : 
				System.out.println("-------------------------Add Materials--------------------------\n");
				System.out.println("Enter the coffee powder quantity in gms : ");
				long coffee = sc.nextLong();
				System.out.println("Enter sugar in gms : ");
				long sugar = sc.nextLong();
				System.out.println("Enter the creamer in ml : ");
				long creamer = sc.nextLong();
				
				boolean isInserted = DatabaseAccessor.addMaterials(coffee, sugar, creamer);
				if(isInserted){
					System.out.println("------------------------------------------------------------------\n");
					 System.out.println("Material Details entered successfully! \n");	 
				}
				else {
					System.out.println("Please enter valid values ");
				}
				break;
			case 2 :
				while(maintain.equalsIgnoreCase("Y")){
					System.out.println("-----------------------------Reports-----------------------------\n");
					System.out.println("          1. Material Status     ");
					System.out.println("          2. Transaction Report      ");
					System.out.println("          3. Back        \n ");
					System.out.println("------------------------------------------------------------------\n");
					System.out.println("Enter an option !");
					report = sc.nextInt();
					
					switch(report){
					
					case 1: SubMenus.getMaterialStatus();
						break;
					case 2 :SubMenus.getTransactionStatus();
						break;
					case 3 :
						maintain = "N";
						break;
					default : 
						System.out.println("Please enter a valid value! Enter only 1-3 ");	
					}
				}
				break;
			case 3 : 
				toggle = "N";
				break;
				default :
					System.out.println("Please enter valid values! Enter only 1-3 ");
					
			}
						
		}
	
	} //end maintenance

}
