/**
 * A class to test BankAccount and its subclasses
 * @author Ian Thompson
 * @version 10.23.2012
 */
public class BankAccountTester
{
	/**
	 * A helper method to perform various operations on a BankAccount,
	 * then end the month
	 * @param account The BankAccount to test
	 */
   public static void test(BankAccount account)
   {
  	 account.deposit(200);
  	 account.withdraw(100);
  	 account.deposit(500);
  	 account.withdraw(400);
  	 account.withdraw(20);
  	 
  	 account.endOfMonth();
   }
   
	public static void main(String[] args)
	{
		BankAccount account = new SavingsAccount(10);
		test(account);
		System.out.println("The SavingsAccount's balance is " + account.getBalance());
		System.out.println("The expected value is 190.0");
		System.out.println();
		
		account = new CheckingAccount(0);
		test(account);
		System.out.println("The CheckingAccount's balance is " + account.getBalance());
		System.out.println("The expected value is 176.0");
		System.out.println();
		
		account = new TimeDepositAccount(10, 2);
		test(account);
		System.out.println("The TimeDepositAccount's balance is "
				+ account.getBalance());
		System.out.println("The expected value is 128.0");
		System.out.println("Bringing the account to maturity");
		account.endOfMonth();
		test(account);
		System.out.println("The TimeDepositAccount's balance is "
				+ account.getBalance());
		System.out.println("The expected value is 334.88");
	}

}
