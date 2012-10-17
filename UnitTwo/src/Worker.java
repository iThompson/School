/**
 * Generic class to represent a worker
 * @author Ian Thompson
 * @version 10.17.2012
 */
public abstract class Worker
{
	private String mName;
	private double mWage;
	
	/**
	 * Constructs a worker, given a name and an hourly wage
	 * @param name The name of the worker
	 * @param wage The hourly wage of the worker
	 */
	public Worker(String name, double wage)
	{
		if (name == null) throw new IllegalArgumentException("Name is null");
		if (wage < 0.0) throw new IllegalArgumentException("Negative salary");
		
		mName = name;
		mWage = wage;
	}
	
	/**
	 * Returns the name of the worker
	 * @return The name of the worker
	 */
	public String getName()
	{
		return mName;
	}
	
	/**
	 * Returns the wage of the worker
	 * @return The wage of the worker
	 */
	public double getWage()
	{
		return mWage;
	}
	
	/**
	 * Computes the pay of the worker, given the number of hours worked
	 * @param hours The number of hours worked
	 * @return The amount the worker should be paid
	 */
	public abstract double computePay(int hours);
}
