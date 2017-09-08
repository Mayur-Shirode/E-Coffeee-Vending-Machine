package com.java.spring.jdbc.dta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
	
	public static java.sql.Date formatDOB(String date) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date java_date = sdf.parse(date);
		java.sql.Date sqlDOB_Date = new java.sql.Date(java_date.getTime());
		return sqlDOB_Date;
		
	}
	
	public static String todayDate(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return (dateFormat.format(date));
		
	}

}
