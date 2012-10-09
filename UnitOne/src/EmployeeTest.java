import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest
{
	private Employee employee;
	
	@Before
	public void setUp()
	{
		employee = new Employee("Fred", 3000);
	}

	@Test
	public void testGetName()
	{
		assertEquals(employee.getName(), "Fred");
	}

	@Test
	public void testGetSalary()
	{
		assertEquals(3000, employee.getSalary(), 0.001);
	}

	@Test
	public void testRaiseSalary()
	{
		employee.raiseSalary(10);
		assertEquals(3300, employee.getSalary(), 0.001);
	}

}
