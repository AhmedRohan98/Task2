package Task2.First;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;


public abstract class Accounts extends Customers {
protected Customers cust;
protected int account_num;
protected double balance;
protected String Date_Created;
protected ArrayList<DateTimeFormatter> Transaction_Date;
protected ArrayList<Double> Transaction_Amount;
protected ArrayList<Double> Transaction_Balance;
protected String Account_Type1;
protected String Account_Type2;

public Accounts() {					//Default Constructor
	cust = new Customers();
	account_num=0;
	balance=0;
	Date_Created="\0";
	Transaction_Date = new ArrayList<DateTimeFormatter>();
	Transaction_Amount = new ArrayList<Double>();
	Account_Type1 = "\0";
	Account_Type2 = "\0";
}

public void CheckBalance() {
	System.out.println("Your total balance is: " + balance);
}

public abstract void makeDeposit(double amount);

//Getters

public double getBalance() {
	return balance;
}

//Setters
public void setBalance(double bal) {
	balance = bal;
}



public void PrintStatement() {
	
	System.out.println("STATEMENT:");
	System.out.println("Account Holder's Name: " + cust.getName());
	System.out.println("Account Number: " + account_num);
	java.time.LocalDateTime date = java.time.LocalDateTime.now(); 
	for(int i=0;i<Transaction_Date.size();i++) {
	System.out.println("Transaction Date and Time: " + Transaction_Date.get(i).format(date));
	System.out.println("Transaction Amount: " + Transaction_Amount.get(i));
	}
	System.out.println("Your Remaining Balance is: " + balance);
	System.out.println("_____________________________________");
}

public void transferAmount(double amount,String Bnk) {
	if(Bnk == null) {
		throw new IllegalArgumentException("Bank name can not be blank");
	}
	balance-=amount;
	System.out.println("The amount of " + amount + "RS has been transferred to " + Bnk);
}

public abstract double displayAllDeductions();

}
