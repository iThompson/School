import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class PaycheckTester
{

	public static void main(String[] args)
	{
		try
		{
			Scanner sc = new Scanner(new File("payData.txt"));
			PrintWriter out = new PrintWriter(new File("paychecks.txt"));
			
			while (sc.hasNext())
			{
				try
				{
					Paycheck check = new Paycheck(sc.next(), sc.nextDouble(),
															sc.nextDouble());
					System.out.println("Writing paycheck for " + check.getName());
					out.println(check.getName() + ": " + check.getPay() + " dollars");
					sc.nextLine();
				}
				catch (NoSuchElementException e)
				{
					System.out.println("Error in reading file: " + e.getMessage());
					sc.nextLine(); // Skip the remainder of the bad record
				}
				catch (IllegalArgumentException e)
				{
					System.out.println("Invalid employee record: " + e.getMessage());
					sc.nextLine();
				}
			}
			
			out.close();
			sc.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not open data file: " + e.getMessage());
		}
	}

}
