import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Tests the Fraction class
 * @author Ian Thompson
 * @version 11.25.2012
 */
public class FractionTester
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int numerator, denominator;
		try
		{
			System.out.print("Numerator: ");
			numerator = sc.nextInt();
			System.out.print("Denominator: ");
			denominator = sc.nextInt();
		}
		catch (InputMismatchException e)
		{
			System.out.println("That's not an integer!");
			sc.close();
			return;
		}
		sc.close();
		
		if (denominator == 0)
		{
			System.out.println("You can't have a denominator of 0!");
			return;
		}
		Fraction frac = new Fraction(numerator, denominator);
		System.out.println("Value is " + frac.getValue());
		System.out.println("Reducing...");
		frac.reduce();
		System.out.println("Reduced numerator is " + frac.getNumerator());
		System.out.println("Reduced denominator is " + frac.getDenominator());
		System.out.println("Reduced value is still " + frac.getValue());
	}

}
