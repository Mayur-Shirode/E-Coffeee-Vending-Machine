package com.java.spring.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static Connection conn = null;
	
	public static Connection getConnection(){
		
		try {
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oralcedb","system","oracleRoot10");
			if(conn != null)
				System.out.println("Connection is estbalished");
			else
				System.out.println("Connection is not estbalished");
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void cleanup(Connection con)
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			
		}
	}

}
