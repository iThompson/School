/**
 * Holds a fraction, with a numerator and denominator, with the ability to reduce
 * @author Ian Thompson
 * @version 11.25.2012
 */
public class Fraction implements Comparable<Fraction>
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
	 * Creates a copy of this fraction, and reduces it
	 * @return A reduced copy of this fraction
	 */
	public Fraction copyAndReduce()
	{
		Fraction frac = new Fraction(mNumerator, mDenominator);
		frac.reduce();
		return frac;
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

	/**
	 * Compares this fraction with another
	 * @param obj The other fraction to compare with
	 * @return -1 if less than, 0 if equal, 1 if greater than
	 */
	@Override
	public int compareTo(Fraction other)
	{
		if (this.equals(other))
		{
			return 0;
		}
		else if (this.getValue() < other.getValue())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	/**
	 * Checks if this Fraction is equal to another
	 * @param obj The other Fraction to check against
	 * @return true if equal, false if unequal or of a different class
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Fraction otherReduced = ((Fraction) obj).copyAndReduce();
		Fraction thisReduced = this.copyAndReduce();
		
		if (thisReduced.mDenominator != otherReduced.mDenominator)
			return false;
		if (thisReduced.mNumerator != otherReduced.mNumerator)
			return false;
		
		return true;
	}
	
	/**
	 * Returns a String showing the values of the fraction
	 * @return A String showing the values of the fraction
	 */
	@Override
	public String toString()
	{
		return mNumerator + "/" + mDenominator;
	}
}
