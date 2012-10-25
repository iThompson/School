
/**
 * An account that earns interest at a fixed rate
 */
public class SavingsAccount extends BankAccount
{
    private double interestRate;
    private double minimum;
    private boolean firstDeposit;
    
    /**
     * Constructs a bank account with a given interest rate.
     * @param rate the interest rate
     */
    public SavingsAccount(double rate)
    {
        interestRate = rate;
        minimum = getBalance();
        firstDeposit = true;
    }
    
    /**
     * Deposits an amount to the account, and if this is the initial deposit,
     * sets the minimum to the balance
     */
    public void deposit(double amount)
    {
   	 super.deposit(amount);
   	 if (firstDeposit)
   	 {
   		 minimum = getBalance();
   		 firstDeposit = false;
   	 }
    }
    
    /**
     * Withdraws a certain amount from the account
     * @param amount The amount to withdraw
     */
    public void withdraw(double amount)
    {
   	 super.withdraw(amount);
   	 if (getBalance() < minimum)
   		 minimum = getBalance();
    }
    
    /**
     * Adds the earned interest to the account balance.
     */
    public void endOfMonth()
    {
        double interest = minimum * interestRate / 100;
        deposit(interest);
        minimum = getBalance();
    }
}