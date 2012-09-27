/**
 * 
 * @author Ian Thompson
 *
 */
public class CarTester
{
	private static void testTankSizeException()
	{
		System.out.print("tankSize: ");
		try
		{
			Car car = new Car(-1.0, 23.0, 12.0, 4.0);
			// Should not get here
			System.out.print("FAILED ");
		}
		catch (IllegalArgumentException e)
		{
			System.out.print("PASSED ");
		}
	}
	
	private static void testInitialFuelException()
	{
		System.out.print("initialFuel: ");
		try
		{
			Car car = new Car(1.0, -23.0, 12.0, 4.0);
			// Should not get here
			System.out.print("FAILED ");
		}
		catch (IllegalArgumentException e)
		{
			System.out.print("PASSED ");
		}
	}
	
	private static void testInitialMileageException()
	{
		System.out.print("initialMileage: ");
		try
		{
			Car car = new Car(1.0, 23.0, -12.0, 4.0);
			// Should not get here
			System.out.print("FAILED ");
		}
		catch (IllegalArgumentException e)
		{
			System.out.print("PASSED ");
		}
	}
	
	private static void testInitialOdometerException()
	{
		System.out.print("initialOdometer: ");
		try
		{
			Car car = new Car(1.0, 23.0, 12.0, -4.0);
			// Should not get here
			System.out.print("FAILED ");
		}
		catch (IllegalArgumentException e)
		{
			System.out.print("PASSED ");
		}
	}
	
	private static void testConstructorExceptions()
	{
		System.out.println("Testing exceptions in the Car constructor");
		
		testTankSizeException();
		testInitialFuelException();
		testInitialMileageException();
		testInitialOdometerException();
		
		System.out.println("");
	}

	public static void main(String[] args)
	{
		testConstructorExceptions();
		
		Car car = new Car(20.0, 15.0, 30.0, 142.6);
	}

}
