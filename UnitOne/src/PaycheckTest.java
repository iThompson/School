import static org.junit.Assert.*;

import org.junit.Test;


public class PaycheckTest
{

	@Test(expected=IllegalArgumentException.class)
	public void testNegativeWage()
	{
		Paycheck check = new Paycheck(-20.0, 5.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeHours()
	{
		Paycheck check = new Paycheck(20.0, -5.0);
	}
	
	

}
