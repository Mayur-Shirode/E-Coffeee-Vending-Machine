package com.java.spring.jdbc.bean;

import java.sql.Date;

public class DebitCardDetails {
	
	long cardNo;
	String debitName;
	Date debitDOB;
	String address1;
	String city;
	String state;
	String country;
	long areaCode;
	long phoneNumber;
	double accountBal;
	int cardPin;
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getDebitName() {
		return debitName;
	}
	public void setDebitName(String debitName) {
		this.debitName = debitName;
	}
	public Date getDebitDOB() {
		return debitDOB;
	}
	public void setDebitDOB(Date debitDOB) {
		this.debitDOB = debitDOB;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(long areaCode) {
		this.areaCode = areaCode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getAccountBal() {
		return accountBal;
	}
	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}
	public int getCardPin() {
		return cardPin;
	}
	public void setCardPin(int cardPin) {
		this.cardPin = cardPin;
	}
	
	

}
