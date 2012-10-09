/**
 * A class to model an employee, with a name and a salary
 * @author Ian Thompson
 * @version 10/8/2012
 */
public class Employee
{
	private String mName;
	private double mSalary;

	/**
	 * Creates the employee
	 * @param employeeName The employee's name
	 * @param currentSalary The employee's initial salary
	 */
	public Employee(String employeeName, double currentSalary)
	{
		mName = employeeName;
		mSalary = currentSalary;
	}
	
	/**
	 * Returns the employee's name
	 * @return The employee's name
	 */
	public String getName()
	{
		return mName;
	}
	
	/**
	 * Returns the employee's salary
	 * @return The employee's salary
	 */
	public double getSalary()
	{
		return mSalary;
	}
	
	/**
	 * Raises the employee's salary
	 * @param byPercent The percentage to raise the salary by
	 */
	public void raiseSalary(double byPercent)
	{
		mSalary += mSalary * byPercent * 0.01;
	}
}
