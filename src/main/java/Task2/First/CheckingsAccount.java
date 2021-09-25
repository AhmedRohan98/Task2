package Task2.First;

import java.time.format.DateTimeFormatter;

public class CheckingsAccount extends Accounts {
	
	private int Transactionsleft;
	private int deductions;
	
	public CheckingsAccount(Customers customer, int acc_num, double bal, String D_C){
		Transactionsleft=2;
		balance=bal;
		Date_Created=D_C;
		account_num=acc_num;
		deductions = 0;
		if(customer.getAccount_Type2() == "\0")
		customer.setAccount_Type2("Checkings");
		else throw new IllegalArgumentException("User already have a Checkings account");
	}

	public double makeWithdrawal(double withdrawal) {
		double x=0;
		
		if(balance+5000 < withdrawal) {
			throw new IllegalArgumentException("The amount exceeds your total balance");
		}
		
		if(balance>=withdrawal) {

			if(Transactionsleft<=0) {
				deductions+=10;
				System.out.println("An Additional amount of 10RS will be deducted from your account");
				balance=balance-10;
			}
			x = balance-withdrawal;
			balance = x;
			Transaction_Amount.add(withdrawal);
			Transaction_Date.add(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
			Transactionsleft--;
		}
		
		else if(balance+5000<withdrawal+5000){
			x=balance+5000-withdrawal;
			balance = x;
			Transactionsleft--;
		}

		return x;
		
	}

	@Override
	public void makeDeposit(double amount) {
		if(amount<0) {
			throw new IllegalArgumentException("Amount can not be less than or equals to 0");
		}
		if(Transactionsleft<=0) {
			deductions+=10;
			System.out.println("An Additional amount of 10RS will be deducted from your account");
			balance=balance-10;
//			Transactionsleft--;
		}
		balance+=amount;
		Transactionsleft--;
		System.out.println("Total Transactions Left" + Transactionsleft);
		Transaction_Amount.add(amount);
		Transaction_Date.add(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
	}

	@Override
	public double displayAllDeductions() {
		System.out.println("Your Total Deduction from your Checkings account is: " + deductions + "RS from Taxes");
		return deductions;
	}
}
