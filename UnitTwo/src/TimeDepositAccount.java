/**
 * A savings account which takes a certain number of months to mature
 * @author Ian Thompson
 * @version 10.22.2012
 */
public class TimeDepositAccount extends SavingsAccount
{
	private int mMonths;
	public final double EARLY_PENALTY = 20.0;
	
	/**
	 * Constructs a TimeDepositAccount, given an interest rate and
	 * minimum number of months
	 * @param interestRate
	 * @param months
	 */
	public TimeDepositAccount(double interestRate, int months)
	{
		super(interestRate);
		mMonths = months;
	}
	
	/**
	 * Applies interest to the account, and brings the account one month closer
	 * to maturing
	 */
	@Override
	public void endOfMonth()
	{
		super.endOfMonth();
		
		if (mMonths > 0)
			mMonths--;
	}
	
	/**
	 * Withdraws an amount from the account, with a penalty for early withdraw
	 * @param amount The amount to withdraw
	 */
	@Override
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		
		if (mMonths != 0)
			super.withdraw(EARLY_PENALTY);
	}
}
