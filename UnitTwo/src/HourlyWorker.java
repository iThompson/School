/**
 * A class to represent an hourly worker
 * @author Ian Thompson
 * @version 10.17.2012
 */
public class HourlyWorker extends Worker
{
	public static final int OVERTIME_HOURS = 40;
	public static final double OVERTIME_RATE = 1.5;
	
	/**
	 * Constructs an hourly worker, given a name and an hourly wage
	 * @param name The name of the worker
	 * @param wage The hourly wage of the worker
	 */
	public HourlyWorker(String name, double wage)
	{
		super(name, wage);
	}

	/**
	 * Calculates the pay for the worker, based on the number of hours worked
	 * @param hours The number of hours worked
	 * @return The amount the worker should be paid
	 */
	@Override
	public double computePay(int hours)
	{
		double pay;
		if (hours > OVERTIME_HOURS)
		{
			pay = getWage() * OVERTIME_HOURS;
			pay += getWage() * OVERTIME_RATE * (hours - OVERTIME_HOURS);
		}
		else
		{
			pay = getWage() * hours;
		}
		return pay;
	}

}
