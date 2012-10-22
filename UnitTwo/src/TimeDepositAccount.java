/**
 * @author Ian Thompson
 * @version 10.22.2012
 */
public class TimeDepositAccount extends SavingsAccount
{
	private int mMonths;
	public final double EARLY_PENALTY = 20.0;
	
	/**
	 * 
	 * @param interestRate
	 * @param months
	 */
	public TimeDepositAccount(double interestRate, int months)
	{
		super(interestRate);
		mMonths = months;
	}
	
	@Override
	public void endOfMonth()
	{
		super.endOfMonth();
		
		if (mMonths > 0)
			mMonths--;
	}
	
	@Override
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		
		if (mMonths != 0)
			super.withdraw(EARLY_PENALTY);
	}
}
