/**
 * A paycheck for an employee
 * @author Ian Thompson
 * @version 10.15.2012
 */
public class Paycheck
{
	private String mName;
	private double mWage;
	private double mHours;
	
	/**
	 * Constructs the Paycheck, given a name, hourly wage, and hours worked
	 * @param name The name of the employee
	 * @param wage The hourly wage of the employee
	 * @param hours The number of hours the employee worked
	 */
	public Paycheck(String name, double wage, double hours)
	{
		if (name == null) throw new IllegalArgumentException("No name");
		if (wage < 0) throw new IllegalArgumentException("Negative wage");
		if (hours < 0) throw new IllegalArgumentException("Negative hours");
		
		mName = name;
		mWage = wage;
		mHours = hours;
	}
	
	/**
	 * Returns the name of the employee
	 * @return The name of the employee
	 */
	public String getName()
	{
		return mName;
	}
	
	/**
	 * Returns the hourly wage of the employee
	 * @return The hourly wage of the employee
	 */
	public double getWage()
	{
		return mWage;
	}
	
	/**
	 * Returns the number of hours the employee worked
	 * @return The number of hours the employee worked
	 */
	public double getHours()
	{
		return mHours;
	}
	
	/**
	 * Returns the amount the employee should be paid
	 * @return The amount the employee should be paid
	 */
	public double getPay()
	{
		double pay;
		
		if (mHours > 40.0)
		{
			pay = mWage * 40;
			pay += (mWage * 1.5) * (mHours - 40.0);
		}
		else
		{
			pay = mWage * mHours;
		}
		
		return pay;
	}
}
