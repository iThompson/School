/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals.
 */
public abstract class BankAccount
{
    private double balance;
    
    /**
     * Constructs a bank account with a zero balance.
     */
    public BankAccount()
    {
        balance = 0;
    }
    
    /**
     * Constructs a bank account with a given balance.
     * @param initialBalance the initial balance
     */
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }
    
    /**
     * Deposits money into the bank account.
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }
    
    /**
     * Withdraws money from the bank account.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }
    
    /**
     * Gets the current balance of the bank account.
     * @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * Transfers money from the bank account to another account.
     * @param amount the amount to transfer
     * @param other the other account
     */
    public void transfer(double amount, BankAccount other)
    {
        withdraw(amount);
        other.deposit(amount);
    }
    
    public abstract void endOfMonth();
    
    public static void test(BankAccount account)
    {
   	 account.deposit(200);
   	 account.withdraw(100);
   	 account.deposit(500);
   	 account.withdraw(600);
   	 account.withdraw(20);
   	 
   	 account.endOfMonth();
    }
}
