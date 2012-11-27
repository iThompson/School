/**
 * Holds a fraction, with a numerator and denominator, with the ability to reduce
 * @author Ian Thompson
 * @version 11.25.2012
 */
public class Fraction
{
	private int mNumerator;
	private int mDenominator;
	
	/**
	 * Creates the fraction, given a numerator and denominator
	 * @param numerator The fraction's numerator
	 * @param denominator The fraction's denominator
	 */
	public Fraction(int numerator, int denominator)
	{
		if (denominator == 0)
			throw new IllegalArgumentException("Zero in denominator!");
		
		mNumerator = numerator;
		mDenominator = denominator;
	}
	
	/**
	 * Returns the fraction's numerator
	 * @return The fraction's numerator
	 */
	public int getNumerator()
	{
		return mNumerator;
	}
	
	/**
	 * Returns the fraction's denominator
	 * @return The fraction's denominator
	 */
	public int getDenominator()
	{
		return mDenominator;
	}
	
	/**
	 * Returns the decimal value of the fraction
	 * @return The decimal value of the fraction
	 */
	public double getValue()
	{
		return (double) mNumerator / mDenominator;
	}
	
	/**
	 * Reduces the numerator and denominator of the fraction to their minimum values
	 */
	public void reduce()
	{
		boolean negative = getValue() < 0;
		
		// Everything must be positive for the gcd
		mNumerator = Math.abs(mNumerator);
		mDenominator = Math.abs(mDenominator);
		
		int gcd = gcd(mNumerator, mDenominator);
		mNumerator /= gcd;
		mDenominator /= gcd;
		
		// Restore negativity
		if (negative)
			mNumerator *= -1;
	}
	
	/**
	 * Finds the greatest common divisor between two numbers
	 * @param a The first number
	 * @param b The second number
	 * @return The greatest common divisor
	 */
	private int gcd(int a, int b)
	{
		if (a < b)
		{
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while (b != 0)
		{
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
}
