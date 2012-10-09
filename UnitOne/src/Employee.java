/**
 * A class to model an employee, with a name and a salary
 * @author Ian Thompson
 *
 */
public class Employee
{
	private String m_name;
	private double m_salary;

	public Employee(String employeeName, double currentSalary)
	{
		m_name = employeeName;
		m_salary = currentSalary;
	}
	
	public String getName()
	{
		return m_name;
	}
	
	public double getSalary()
	{
		return m_salary;
	}
	
	public void raiseSalary(double byPercent)
	{
		m_salary += m_salary * byPercent * 0.01;
	}
}
