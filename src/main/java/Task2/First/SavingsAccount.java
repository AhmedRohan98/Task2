package Task2.First;

import java.time.format.DateTimeFormatter;

public class SavingsAccount extends Accounts {
private float interest_rate;
private double Zakaat;

public SavingsAccount(float int_rate, Customers customer, int acc_num, double bal, String D_C) {
	interest_rate = int_rate;
	account_num=acc_num;
	balance=bal;
	Date_Created=D_C;
	Zakaat = 0;
	if(customer.getAccount_Type1() == "\0")
	customer.setAccount_Type1("Savings");
	else throw new IllegalArgumentException("User already have a Savings account");
}

public float CalculateInterest_rate() {
	return (float) ((interest_rate/100)*balance+balance);
}

public double CalculateZakat(){
	double x=0;
	if(balance>=20000) {
		x=(balance*2.5)/100;
		Zakaat=x;
	}
	
	else throw new IllegalArgumentException("you are not Eligible for Zakaat");
	
	return Zakaat;
}

public double makeWithdrawal(double withdrawal) {
	
	double x=0;
	if(balance>=withdrawal) {
	x = balance-withdrawal;
	balance = x;
	Transaction_Amount.add(withdrawal);
	Transaction_Date.add(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
	}
	
	else throw new IllegalArgumentException("The Amount Exceeds Your Total Balance"); 
	return x;
	
}


@Override
public void makeDeposit(double amount) {
	if(amount<=0) {
		throw new IllegalArgumentException("Amount can not be less than or equals to 0");
	}
	balance+=amount;

	Transaction_Amount.add(amount);
	Transaction_Date.add(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
}

@Override
public double displayAllDeductions() {
	System.out.println("Your Deduction from your savings account is " + Zakaat + " deducted from your total of zakaat");
	return CalculateZakat();
}
}
