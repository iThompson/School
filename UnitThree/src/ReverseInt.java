import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Reads an integer (actually a long) off of the console, and reversed its digits
 * @author Ian Thompson
 * @version 11/17/2012
 */
public class ReverseInt
{
	
	/**
	 * Reverses the order of digits in an integer
	 * @param num The integer to reverse
	 * @return The reversed integer
	 */
	private static long flipNum(long num)
	{
		boolean sign = num < 0;
		num = Math.abs(num);
		
		long ret = 0;
		while (num > 0)
		{
			ret *= 10;
			ret += num % 10;
			num /= 10;
		}
		
		if (sign) 
			ret = -ret;
		
		return ret;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Input an integer: ");
		long val;
		try
		{
			val = sc.nextLong();
		}
		catch (InputMismatchException e)
		{
			System.out.println("That's not an integer!");
			sc.close();
			return;
		}
		
		System.out.println("The reversed value is " + flipNum(val));
		sc.close();
	}

}
