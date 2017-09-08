package com.java.spring.jdbc.dta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import com.java.spring.jdbc.bean.CreditCardDetails;
import com.java.spring.jdbc.bean.DebitCardDetails;
import com.java.spring.jdbc.bean.MaterialDetails;
import com.java.spring.jdbc.queries.QueryConstants;
import com.java.spring.jdbc.util.ConnectionUtil;



public class DatabaseAccessor {
	
	static int table_count = 0; 
	static Connection conn = ConnectionUtil.getConnection();
	static PreparedStatement ps = null;
	static Statement st = null;
	ResultSet rs = null;
	
	
	
	
	public static boolean addCreditCardDetails(long cardNo, String name, Date dob, String address, String city,
			String state, String country, int pin, long phoneNo, int creditLimit, String validity) throws SQLException{
		
		int count = 0;
		boolean isInsert;
		
		ps = conn.prepareStatement(QueryConstants.INSERT_CREDIT_CARD);
		ps.setLong(1, cardNo);
		ps.setString(2, name);
		ps.setDate(3, dob);
		ps.setString(4, address);
		ps.setString(5, city);
		ps.setString(6, state);
		ps.setString(7, country);
		ps.setInt(8, pin);
		ps.setLong(9, phoneNo);
		ps.setInt(10, creditLimit);
		ps.setString(11, validity);
		
		count = ps.executeUpdate();
		if(count != 0){
			isInsert = true;
		}
		else {
			isInsert = false;
		}
		return isInsert;
	}
	
	public static boolean addDebitCardDetails(long cardNo, String name, Date dob, String address, String city,
			String state, String country, int pincode, long phoneNo, double opBal, int pin) throws SQLException{
		
		int count = 0;
		boolean isInsert;
		
		ps = conn.prepareStatement(QueryConstants.INSERT_DEBIT_CARD);
		ps.setLong(1, cardNo);
		ps.setString(2, name);
		ps.setDate(3, dob);
		ps.setString(4, address);
		ps.setString(5, city);
		ps.setString(6, state);
		ps.setString(7, country);
		ps.setInt(8, pincode);
		ps.setLong(9, phoneNo);
		ps.setDouble(10, opBal);
		ps.setInt(11, pin);
		
		count = ps.executeUpdate();
		if(count != 0){
			isInsert = true;
		}
		else {
			isInsert = false;
		}
		return isInsert;
	}
	
	
	public static boolean addMaterials(long coffee, long sugar, long creamer) throws SQLException{
		
		int count = 0;
		int update_counter = 0;
		boolean isInsert;
		ps = conn.prepareStatement(QueryConstants.SELECT_MATERIALS);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			long coffee_powder = rs.getLong(1);
			long sugar_powder = rs.getLong(2);
			long creamer_ml = rs.getLong(3);
		
		
		if(coffee_powder != 0){
			coffee_powder += coffee;
			ps = conn.prepareStatement(QueryConstants.UPDATE_COFFEE_MATERIAL);
			ps.setLong(1, coffee_powder);
			update_counter = ps.executeUpdate();
		}
		
		 if(sugar_powder != 0){
			sugar_powder += sugar;
			ps = conn.prepareStatement(QueryConstants.UPDATE_SUGAR_MATERIAL);
			ps.setLong(1, sugar_powder);
			update_counter += ps.executeUpdate();
		}
		
		 if(creamer_ml != 0){
			creamer_ml += creamer;
			ps = conn.prepareStatement(QueryConstants.UPDATE_CREAMER_MATERIAL);
			ps.setLong(1, creamer_ml);
			update_counter += ps.executeUpdate();
		}
		
		
		}
		if(update_counter >= 1){
			isInsert = true;
		}
		else{
			
			ps = conn.prepareStatement(QueryConstants.INSERT_MATERIALS);
			ps.setLong(1, coffee);
			ps.setLong(2, sugar);
			ps.setLong(3, creamer);
			
			count = ps.executeUpdate();
			if(count != 0){
				isInsert = true;
			}
			else{
				isInsert = false;
			}
		}
		
		
		return isInsert;
		
	}
	
	public static MaterialDetails retrieveMaterials() throws SQLException{
		
		ResultSet rs = null;
		MaterialDetails ms = new MaterialDetails();
		
		ps = conn.prepareStatement(QueryConstants.SELECT_MATERIALS);
		rs = ps.executeQuery();
		
		while(rs.next()){
			ms.setCoffee(rs.getLong(1));
			ms.setSugar(rs.getLong(2));
			ms.setCreamer(rs.getLong(3));	
		}
		
		return ms;
	}
	
	public static int getQuantityWhiteCoffee() throws SQLException{
		
		ResultSet rs = null;
		int white_quantity = 0;
		
		ps = conn.prepareStatement(QueryConstants.COUNT_WHITE_COFFEE);
		rs = ps.executeQuery();
		
		while(rs.next()){
			white_quantity = rs.getInt(1);
		}
		
		return white_quantity;
		
	}
	
	public static int getQuantityBlackCoffee() throws SQLException{
			
			ResultSet rs = null;
			int black_quantity = 0;
			
			ps = conn.prepareStatement(QueryConstants.COUNT_BLACK_COFFEE);
			rs = ps.executeQuery();
			
			while(rs.next()){
				black_quantity = rs.getInt("count_black");
			}
			
			return black_quantity;
			
		}
	
	public static int getSumWhiteCoffee() throws SQLException{
			
		ResultSet rs = null;
		int white_sum = 0;
		
		ps = conn.prepareStatement(QueryConstants.SUM_WHITE_COFFEE);
		rs = ps.executeQuery();
		
		while(rs.next()){
			white_sum = rs.getInt(1);
		}
		
		return white_sum;
		
	}
	
	public static int getSumBlackCoffee() throws SQLException{
		
		ResultSet rs = null;
		int black_sum = 0;
		
		ps = conn.prepareStatement(QueryConstants.SUM_BLACK_COFFEE);
		rs = ps.executeQuery();
		
		while(rs.next()){
			int sum = rs.getInt("sum_black");
			black_sum += sum;
		}

		System.out.println(black_sum);
		return black_sum;
		
	}
	
	public static boolean addTransactionDetails(String coffeeType, String paymentType, int totalCost) throws SQLException, ParseException{
		
		int count;
		boolean isInsert = false;
		boolean coffeeUpdate = false;
		ps = conn.prepareStatement(QueryConstants.ORDER_COFFEE);
		ps.setString(1, coffeeType);
		ps.setString(2, paymentType);
		ps.setInt(3, totalCost);
		
		count = ps.executeUpdate();
		if(count != 0){
			if(coffeeType.equalsIgnoreCase("white")){
				coffeeUpdate = whiteCoffeeMaterials();
			}
			else if(coffeeType.equalsIgnoreCase("black")){
				coffeeUpdate = blackCoffeeMaterials();
			}
			if(coffeeUpdate){
				isInsert = true;
			}
			else{
				isInsert = false;
			}
		}
		
	
		return isInsert;
	}
	
	public static boolean whiteCoffeeMaterials() throws SQLException{
		
		MaterialDetails md = new MaterialDetails();
		md = retrieveMaterials();
		int count;
		boolean isUpdated = false;
		
		if(md != null){
			 long coffee = md.getCoffee();
			 long sugar = md.getSugar();
			 long cream = md.getCreamer();
			 
			 if(coffee != 0 && coffee > 15 && sugar !=0 && sugar > 10 && cream != 0 && cream > 25){
				 
				 coffee = coffee - 7;
				 sugar = sugar - 5;
				 cream = cream - 15;
				 
				 ps = conn.prepareStatement(QueryConstants.UPDATE_MATERIALS);
				 ps.setLong(1, coffee);
				 ps.setLong(2, sugar);
				 ps.setLong(3, cream);
				 
				 count = ps.executeUpdate();
				 
				 if(count != 0){
					 isUpdated = true;
				 }	 
			 }
			 else{
				 System.out.println("Oops! There is not enough materials to make your coffee!");
			 }
		}	
		return isUpdated;	
	}

public static boolean blackCoffeeMaterials() throws SQLException{
		
		MaterialDetails md = new MaterialDetails();
		md = retrieveMaterials();
		int count;
		boolean isUpdated = false;
		
		if(md != null){
			 long coffee = md.getCoffee();

			 
			 if(coffee != 0 && coffee > 15){
				 
				 coffee = coffee - 15;
				 
				 
				 ps = conn.prepareStatement(QueryConstants.UPDATE_COFFEE_MATERIAL);
				 ps.setLong(1, coffee);
				 
				 
				 count = ps.executeUpdate();
				 
				 if(count != 0){
					 isUpdated = true;
				 }	 
			 }
			 
			 else{
				 System.out.println("Oops! There is not enough materials to make your coffee!");
			 }
		}	
		return isUpdated;	
	}

	public static boolean validateCreditCard(long cardNo, String validity) throws SQLException{
		
		CreditCardDetails cc = new CreditCardDetails();
		ps = conn.prepareStatement(QueryConstants.CREDIT_DETAILS);
		ps.setLong(1, cardNo);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			cc.setCardNo(rs.getLong(1));
			cc.setCardName(rs.getString(2));
			cc.setDob(rs.getDate(3));
			cc.setAddress1(rs.getString(4));
			cc.setCity(rs.getString(5));
			cc.setState(rs.getString(6));
			cc.setCountry(rs.getString(7));
			cc.setAreaCode(rs.getLong(8));
			cc.setPhoneNumber(rs.getLong(9));
			cc.setCreditLimit(rs.getInt(10));
			cc.setValidity(rs.getString(11));
			
		}
		
		if(cc.getCreditLimit() > 0 && cc.getValidity().equalsIgnoreCase(validity)){
			return true;
		}
		else return false;
	}

	public static boolean validateDebitCard(long debitNo, int pinNumber, int amount) throws SQLException{
		
		DebitCardDetails dc = new DebitCardDetails();
		boolean result = false;
		ps = conn.prepareStatement(QueryConstants.DEBIT_DETAILS);
		ps.setLong(1, debitNo);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			dc.setCardNo(rs.getLong(1));
			dc.setDebitName(rs.getString(2));
			dc.setDebitDOB(rs.getDate(3));
			dc.setAddress1(rs.getString(4));
			dc.setCity(rs.getString(5));
			dc.setState(rs.getString(6));
			dc.setCountry(rs.getString(7));
			dc.setAreaCode(rs.getLong(8));
			dc.setPhoneNumber(rs.getLong(9));
			dc.setAccountBal(rs.getDouble(10));
			dc.setCardPin(rs.getInt(11));	
		}
		
		if(dc.getCardPin() == pinNumber){
			
			if(dc.getAccountBal() > 100 ){
				ps = conn.prepareStatement(QueryConstants.UPDATE_DEBIT_AMT);
				ps.setDouble(1, (dc.getAccountBal() - amount));
				int updateAmt = ps.executeUpdate();
				
				if(updateAmt != 0){
					result = true;
				}
				else{
					result = false;
				}
				
				result = true;
			}
			
			else{
				result = false;
			}
			
			result = true;
		}
		
		else {
			result = false;
		}
		
		return result;
	}
}
