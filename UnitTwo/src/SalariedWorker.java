/**
 * A class to represent a worker with a constant salary, based off an hourly pay
 * @author Ian Thompson
 * @version 10.17.2012
 */
public class SalariedWorker extends Worker
{
	public static final int SALARY_HOURS = 40;

	/**
	 * Constructs a salaried worker, given an hourly wage and a name
	 * @param name The name of the worker
	 * @param wage The hourly wage of the worker
	 */
	public SalariedWorker(String name, double wage)
	{
		super(name, wage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Computes the pay of the worker, regardless of number of hours worked
	 * @param hours The number of hours worked
	 * @return The amount the worker should be paid
	 */
	@Override
	public double computePay(int hours)
	{
		return getWage() * SALARY_HOURS;
	}

}
