/**
 * A paycheck for an employee
 * @author Ian Thompson
 *
 */
public class Paycheck
{
	private double mWage;
	private double mHours;
	
	public Paycheck(double wage, double hours)
	{
		if (wage < 0) throw new IllegalArgumentException("Negative wage");
		if (hours < 0) throw new IllegalArgumentException("Negative hours");
		
		mWage = wage;
		mHours = hours;
	}
	
	public double getWage()
	{
		return mWage;
	}
	
	public double getHours()
	{
		return mHours;
	}
	
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
