
/**
 * An account that earns interest at a fixed rate
 */
public class SavingsAccount extends BankAccount
{
    private double interestRate;
    private double minimum;
    
    /**
     * Constructs a bank account with a given interest rate.
     * @param rate the interest rate
     */
    public SavingsAccount(double rate)
    {
        interestRate = rate;
        minimum = getBalance();
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