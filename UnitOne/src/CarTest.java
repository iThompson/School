import static org.junit.Assert.*;

import org.junit.Test;


public class CarTest
{

	@Test(expected=IllegalArgumentException.class)
	public void testTankSize()
	{
		Car car = new Car(-30, 23, 12, 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInitialFuel()
	{
		Car car = new Car(30, -23, 12, 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInitialMileage()
	{
		Car car = new Car(30, 23, -12, 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInitialOdometer()
	{
		Car car = new Car(30, 23, 12, -4);
	}
	
	@Test
	public void testMaximums()
	{
		Car car = new Car(20.0, 15.0, 30.0, 142.6);
		car.setSpeed(40.0);
		
		assertEquals("maxDistance", 450.0, car.getMaxDistance(), 0.01);
		assertEquals("maxTime", 11.25, car.getMaxTime(), 0.01);
	}
	
	@Test
	public void testOverFill()
	{
		Car car = new Car(20.0, 15.0, 30.0, 142.6);
		car.addFuel(100.0);
		
		assertEquals("currentFuel", 20.0, car.getCurrentFuel(), 0.001);
	}

}
