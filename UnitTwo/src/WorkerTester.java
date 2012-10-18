import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A class to test the Worker class and its subclasses
 * @author Ian Thompson
 * @version 10.10.2012
 */
public class WorkerTester
{
	/**
	 * A helper method which asks for the parameters for a Worker
	 * @param sc The Scanner to pull the input from
	 * @return A Worker, constructed based on the user input
	 */
	private static Object askForWorker(Scanner sc)
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

			String classType;
			if (type.equalsIgnoreCase("H"))
			{
				classType = "HourlyWorker";
			}
			else if (type.equalsIgnoreCase("S"))
			{
				classType = "SalariedWorker";
			}
			else
			{
				System.out.println("That's not a valid type!");
				return null;
			}
			
			try
			{
				return Class.forName(classType).getConstructor(String.class, double.class).newInstance(name, wage);
			}
			catch (Exception e)
			{
				System.out.println("ERROR: " + e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Failed to parse input: " + e.getMessage());
			sc.nextLine();
			return null;
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Invalid arguments: " + e.getMessage());
			sc.nextLine();
			return null;
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Object work;
		boolean stop = false;
		
		while (!stop)
		{
			work = askForWorker(sc);
			
			if (work == null)
			{
				System.out.println("Failed to create worker");
			}
			else
			{
				try
				{
					System.out.println("The " + work.getClass().getName() + " "
							+ work.getClass().getMethod("getName").invoke(work) + "'s pay for 35 hours is " + work.getClass().getMethod("computePay", int.class).invoke(work, 35));
					System.out.println("The " + work.getClass().getName() + " "
							+ work.getClass().getMethod("getName").invoke(work) + "'s pay for 55 hours is " + work.getClass().getMethod("computePay", int.class).invoke(work, 55));
				}
				catch (Exception e)
				{
					System.out.println("ERROR: " + e.getMessage());
					e.printStackTrace();
				}
			}
			System.out.println("Type C to continue, or anything else to stop");
			String reply = sc.nextLine();
			if (!reply.equalsIgnoreCase("C"))
				stop = true;
		}
		System.out.println("Goodbye!");
	}

}

// Class.forName("HourlyWorker").getMethod("computePay", int.class).invoke(Class.forName("HourlyWorker").getConstructor(String.class, double.class).newInstance("John Doe", 35.0), 45);
