/**
 * A class to test Car
 * 
 * @author Ian Thompson
 *
 */
public class CarTester
{
	/**
	 * A helper for testConstructorExceptions which performs the actual test
	 * 
	 * @param name The argument being tested
	 * @param tankSize The car's tankSize
	 * @param initialFuel The car's initialFuel
	 * @param milesPerGallon The car's milesPerGallon
	 * @param initialOdometer The car's initialOdometer
	 */
	@SuppressWarnings("unused")
	private static void testConstructorArgument(String name, double tankSize,
			double initialFuel, double milesPerGallon, double initialOdometer)
	{
		System.out.print(name + ": ");
		try
		{
			Car car = new Car(tankSize, initialFuel, milesPerGallon, initialOdometer);
			// Should not get here
			System.out.print("FAILED ");
		}
		catch (IllegalArgumentException e)
		{
			System.out.print("PASSED ");
		}
		catch (Exception e)
		{
			System.out.print("WRONG ");
		}
	}
	
	/**
	 * Checks that the constructor for Car generates the proper exceptions
	 */
	private static void testConstructorExceptions()
	{
		System.out.println("Testing exceptions in the Car constructor");
		
		testConstructorArgument("tankSize", -30.0, 23.0, 12.0, 4.0);
		testConstructorArgument("initialFuel", 30.0, -23.0, 12.0, 4.0);
		testConstructorArgument("initialMileage", 30.0, 23.0, -12.0, 4.0);
		testConstructorArgument("initialOdometer", 30.0, 23.0, 12.0, -4.0);
		
		System.out.println("");
	}

	public static void main(String[] args)
	{
		testConstructorExceptions();
		
		Car car = new Car(20.0, 15.0, 30.0, 142.6);
		car.setSpeed(40.0);
		
		System.out.println("Maximum distance is " + car.getMaxDistance() + " miles");
		System.out.println("Expected value is 450.0 miles");
		System.out.println("Maximum time is " + car.getMaxTime() + " hours");
		System.out.println("Expected value is 11.25 hours");
		
		car.driveDistance(250.0);
		System.out.println("Odometer value is " + car.getOdometer() + " miles");
		System.out.println("Expected value is 392.6");
		System.out.println("Amount of fuel is " + car.getCurrentFuel() + " gallons");
		System.out.println("Expected value is 6.66666666 gallons");
		
		car.driveTime(2);
		System.out.println("Odometer value is " + car.getOdometer() + " miles");
		System.out.println("Expected value is 472.6 miles");
		System.out.println("Amount of fuel is " + car.getCurrentFuel() + " gallons");
		System.out.println("Expected value is 4.0 gallons");
		
		System.out.println("Draining tank!");
		car.driveDistance(10000000.0);
		System.out.println("Odometer value is " + car.getOdometer() + " miles");
		System.out.println("Expected value is 592.6 miles");
		System.out.println("Amount of fuel is " + car.getCurrentFuel() + " gallons");
		System.out.println("Expected value is 0.0 gallons");
		
		car.addFuel(10.0);
		System.out.println("Amount of fuel is " + car.getCurrentFuel() + " gallons");
		System.out.println("Expected value is 10.0 gallons");
		
		System.out.println("Overfilling tank!");
		car.addFuel(100.0);
		System.out.println("Amount of fuel is " + car.getCurrentFuel() + " gallons");
		System.out.println("Expected value is 20.0 gallons");
	}

}
