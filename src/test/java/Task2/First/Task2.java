package Task2.First;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Task2 {
	Customers customer1, customer2;
	
	SavingsAccount SA,SA2;
	
	CheckingsAccount CA,CA2;
	@Before
	public void SetUp() {
		customer1 = new Customers("Ahmed Rohan",54321,"House No. L-1",5);
		customer2 = new Customers("Ahmed",54321,"House No. L-1",5);
		SA = new SavingsAccount(2, customer1, 1, 50000, "13/09/21");
		SA2 = new SavingsAccount(2, customer2, 1, 10000, "13/09/21");
//		SA2 = new SavingsAccount(2, customer1, 1, 50000, "13/09/21");
		CA = new CheckingsAccount(customer1, 1, 30000, "13/09/21");
//		CA2 = new CheckingsAccount(customer1, 1, 30000, "13/09/21");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CustomerConstructorNullTest() {
		customer2 = new Customers(null,54321,"House No. L-1",5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CustomerConstructorShortTest() {
		customer2 = new Customers("fo",54321,"House No. L-1",5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CustomerConstructorLongTest() {
		customer2 = new Customers("fooooooooooooooooooooooooooooooooooo",54321,"House No. L-1",5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NullNameTest() {
		SA.setName(null);
		assertNull(SA.getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ShortNameTest() {
		String name = "fo";
		SA.setName(name);
		assertEquals(SA.getName(),"fo");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void LongNameTest() {
		String name = "fooooooooooooooooooooooooooooooooooooooooooo";
		SA.setName(name);
		assertEquals(SA.getName(),"fooooooooooooooooooooooooooooooooooooooooooo");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NullAddressTest() {
		customer1.setAddress("House No. L-1");
		assertEquals(customer1.getAddress(),"House No. L-1");
		customer1.setAddress(null);
		assertNull(customer1.getAddress());
	}
	
	
	@Test
	public void CheckBalanceTest() {
		CA.CheckBalance();
	}
	
	@Test
	public void PrintStatementTest() {
		SA.makeDeposit(2000);
		SA.makeWithdrawal(1000);
		SA.makeDeposit(1000);
		SA.PrintStatement();
	}
	
	@Test
	public void setNameTest() {
		String name = "Ahmed Rohan";
		SA.setName(name);
		assertEquals(SA.getName(),"Ahmed Rohan");
	}
	
	
	@Test
	public void LimitedTransactions() {
		CA.makeDeposit(3000);
		CA.makeDeposit(3000);
		CA.makeDeposit(1000);
		CA.makeWithdrawal(3000);
//		CA.makeDeposit(1000);
		double expected = CA.getBalance();
		assertTrue(expected == 33980);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void TwoSavingsAccount() {
		SA2 = new SavingsAccount(2, customer1, 1, 50000, "13/09/21");
	}

	@Test(expected = IllegalArgumentException.class)
	public void TwoCheckingsAccount() {
		CA2 = new CheckingsAccount(customer1, 1, 30000, "13/09/21");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void SavingsMakeDepositLessThanZeroTest() {
		SA.makeDeposit(-10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckingsMakeDepositLessThanZeroTest() {
		CA.makeDeposit(-10);
	}
	
	@Test
	public void SavingsMakeDepositTest() {
		double expectedBalance = SA.getBalance();
		SA.makeDeposit(10000);
		expectedBalance+=10000;
		assertTrue(expectedBalance==SA.getBalance());
	}
	
	@Test
	public void SavingsMakeWithdrawalTest() {
		double oldBalance = SA.getBalance();
		double newBalance = SA.makeWithdrawal(5000);
		assertTrue(oldBalance-5000 == newBalance);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void SavingsllegalMakeIWithdrawalTest() {
		SA.makeWithdrawal(75000);
		assertTrue(SA.getBalance() == 50000);
	}
	
	@Test
	public void CheckingsMakeWithdrawalTest() {
		double oldBalance = CA.getBalance();
		double newBalance = CA.makeWithdrawal(6000);
		assertTrue(oldBalance-6000 == newBalance);
	}
	
	@Test
	public void CheckingsMakeWithdrawalTest2() {
		CA.makeWithdrawal(33000);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckingsllegalMakeIWithdrawalTest() {
		CA.makeWithdrawal(75000);
	}
	
	@Test
	public void SavingsGetBalanceTest() {
		double bal = SA.getBalance();
		assertTrue(bal == 50000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ZakaatTest() {
		assertTrue(SA.CalculateZakat()!=0);
		SA.setBalance(10000);
		assertTrue(SA.CalculateZakat()==0);
	}
	
	@Test
	public void CalculateInterestRateTest() {
		assertTrue(SA.CalculateInterest_rate() == 51000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TransferAmountIllegalTest() {
		CA.transferAmount(3000, null);
	}
	
	@Test
	public void TransferAmountTest() {
		CA.transferAmount(3000, "Habib Bank");
	}
	
	@Test
	public void SavingsDisplayAllDeductionsTest() {
		SA.makeDeposit(3000);
		SA.makeWithdrawal(3000);
		SA.makeDeposit(3000);
		SA.makeWithdrawal(3000);
		SA.displayAllDeductions();
	}
	
	@Test
	public void CheckingsDisplayAllDeductionsTest() {
		CA.makeDeposit(3000);
		CA.makeWithdrawal(3000);
		CA.makeDeposit(3000);
		CA.makeWithdrawal(3000);
		CA.displayAllDeductions();
	}
	
	@Test
	public void getP_NumberTest() {
		int p = customer1.getPNumber();
		assertTrue(p == 54321);
	}
	
	@Test
	public void getAcc_NumTest() {
		int p = customer1.getAccNum();
		assertTrue(p == 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ConstructorNullAddress() {
		customer2 = new Customers("Ahmed Rohan",54321,null,5);
		assertNull(customer2.getAddress());
	}
	
	
}