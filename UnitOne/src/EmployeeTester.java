/**
 * A class to test the Employee class
 * @author Ian Thompson
 * @version 10/8/2012
 */
public class EmployeeTester
{

	public static void main(String[] args)
	{
		Employee employee = new Employee("Fred", 3000.0);
		
		System.out.println("Testing the Employee class");
		System.out.println();
		
		System.out.println("Name is " + employee.getName());
		System.out.println("Expected value is Fred");
		System.out.println();
		
		System.out.println("Salary is " + employee.getSalary());
		System.out.println("Expected value is 3000.0");
		System.out.println();
		
		System.out.println("Raising salary");
		employee.raiseSalary(10);
		System.out.println("Salary is " + employee.getSalary());
		System.out.println("Expected value is 3300.0");
	}

}
