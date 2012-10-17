import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A class to test the Worker class and its subclasses
 * @author Ian Thompson
 *
 */
public class WorkerTester
{
	private static Worker askForWorker(Scanner sc)
	{
		try
		{
			System.out.print("What is the name of the worker? ");
			String name = sc.nextLine();
			System.out.print("What is the worker's hourly wage? ");
			double wage = sc.nextDouble();
			sc.nextLine(); // Make sure to skip any extra text
			System.out.print("H for hourly worker, S for salaried worker: ");
			String type = sc.next();
			sc.nextLine();

			if (type.equalsIgnoreCase("H"))
			{
				return new HourlyWorker(name, wage);
			}
			else if (type.equalsIgnoreCase("S"))
			{
				return new SalariedWorker(name, wage);
			}
			else
			{
				return null;
			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Failed to parse input: " + e.getMessage());
			return null;
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Invalid arguments: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Worker work;
		boolean stop = false;
		
		while (!stop)
		{
			work = askForWorker(sc);
			
			if (work == null)
			{
				System.out.println("Failed to create worker");
			}
		}
		
		System.out.println("The " + work.getClass().getName() + " " 
								+ work.getName() + "'s pay is " + work.computePay(35));
		System.out.println("John Doe's pay should be 525.0");
		
		work = new SalariedWorker("Jane Doe", 15.0);
		System.out.println("The " + work.getClass().getName() + " " 
								+ work.getName() + "'s pay is " + work.computePay(35));
		System.out.println("Jane Doe's pay should be 600.0");
	}

}
