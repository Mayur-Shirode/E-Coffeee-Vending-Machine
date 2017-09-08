package com.java.spring.jdbc.queries;

public interface QueryConstants {
	
	String DROP_TABLE_MATERIAL = "Drop table materialDetails Purge";
	String DROP_TABLE_VENDOR_PWD = "Drop table vendor Purge";
	String DROP_TABLE_CREDITCARD = "Drop table creditCardHolders Purge ";
	String DROP_TABLE_DEBITCARD = "Drop table debitCardHolders Purge";
	String DROP_TABLE_TRANSACTIONREC = "Drop table transactionRecord Purge";
	
	String CREATE_TABLE_MATERIAL = "Create table materialDetails(coffee_powder number(10), sugar number(10), creamer number(10))";
	String CREATE_TABLE_VENDOR = "Create table vendor(vendor_name varchar2(20), password varchar2(25))";
	String CREATE_CREDIT_CARD = "Create table creditCardHolders(credit_card_number number(10), credit_name varchar2(25), credit_dob date, credit_address varchar2(150),  credit_city varchar2(25), credit_state varchar2(25), credit_country varchar2(30), credit_pincode number(10), credit_phone_number number(10), credit_limit number, validity varchar2(7))";
	String CREATE_DEBIT_CARD = "Create table debitCardHolders(debit_card_number number(10), debit_name varchar2(25), debit_dob date, debit_address varchar2(150),  debit_city varchar2(25), debit_state varchar2(25), debit_country varchar2(30), debit_pincode number(10), debit_phone_number number(10), act_balance number, debit_pin number(4))";
	String CREATE_TRANSACTION_RECORD = "Create table transactionRecord(transaction_id number(10), transaction_date date, coffee_type varchar2(20), payment_type varchar2(15), coffee_value number(5),  constraint pk_transaction_id PRIMARY KEY(transaction_id))";
	String CREATE_SEQUENCE = "Create sequence transactionId_sequence start with 1 increment by 1 minvalue 1 maxvalue 10000000";

	String INSERT_CREDIT_CARD = "Insert into creditCardHolders values(?, ?, TO_DATE(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?)";
	String INSERT_DEBIT_CARD = "Insert into debitCardHolders values(?, ?, TO_DATE(?, 'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?)" ;
	String INSERT_MATERIALS = "Insert into materialDetails values(?, ?, ?)";
	String UPDATE_COFFEE_MATERIAL = "Update materialDetails set coffee_powder = ?";
	String UPDATE_SUGAR_MATERIAL = "Update materialDetails set sugar = ?";
	String UPDATE_CREAMER_MATERIAL = "Update materialDetails set creamer = ?";
	
	String UPDATE_MATERIALS = "Update materialDetails set coffee_powder = ?, sugar = ? , creamer = ? ";
	
	String SELECT_MATERIALS = "Select * from materialDetails";
	String COUNT_WHITE_COFFEE = "Select count(*) as count_white from transactionRecord where upper(coffee_type) like upper('white') ";
	String COUNT_BLACK_COFFEE = "Select count(*) as count_black from transactionRecord where upper(coffee_type) like upper('black') ";
	String SUM_WHITE_COFFEE = "Select sum(coffee_value) as sum_white from transactionRecord where upper(coffee_type) like upper('white') ";
	String SUM_BLACK_COFFEE = "Select sum(coffee_value) as sum_black from transactionRecord where upper(coffee_type) like upper('black') ";
	String ORDER_COFFEE = "Insert into transactionRecord(transaction_id,transaction_date,coffee_type, payment_type, coffee_value) values(transactionId_sequence.nextval, trunc(sysdate), ?, ?, ? )";
	String CREDIT_DETAILS = "Select * from creditCardHolders where credit_card_number = ?"; 
	String DEBIT_DETAILS = "Select * from debitCardHolders where debit_card_number = ?";
	String UPDATE_DEBIT_AMT = "Update debitCardHolders set act_balance = ?";
	
}
