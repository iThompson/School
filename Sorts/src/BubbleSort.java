import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for performing bubble sorts
 * @author Ian Thompson
 * @version 1.30.2013
 */
public class BubbleSort
{
	public static int SIZE = 50;

	public static void main(String[] args)
	{
		ArrayList<Fraction> values = new ArrayList<Fraction>();
		for (int i = 0; i < SIZE; i++)
		{
			values.add(new Fraction((int)(Math.random() * 100),
											(int)(Math.random() * 100 + 1)));
		}
		
		print(values);
		
		System.out.println("Performing bubble sort");
		bubbleSort(values);
		
		print(values);
	}
	
	/**
	 * Prints an array of Fractions to the console
	 * @param values The array to print
	 */
	public static void print(ArrayList<Fraction> values)
	{
		
		Fraction value;
		System.out.println("the values array is:");
		for (int index = 0; index < values.size(); index++)
		{
			value = values.get(index);
			if (((index + 1) % 10) == 0)
				System.out.println(value);
			else
				System.out.print(value + " ");
		}
		System.out.println();
	}
	
	/**
	 * Performs a bubble sort on the given array
	 * @param data The array to sort
	 */
	public static void bubbleSort(ArrayList<Fraction> data)
	{
		for (int current = 0; current < data.size() - 1; current++)
			bubbleUp(data, current, data.size() - 1);
	}
	
	/**
	 * Bubbles up a range in the given array
	 * @param data The array to operate on
	 * @param startIndex The start index of the range
	 * @param endIndex The end index of the range
	 */
	private static void bubbleUp(ArrayList<Fraction> data,
										  int startIndex, int endIndex)
	{
		for (int i = endIndex; i > startIndex; i--)
		{
			if (data.get(i).compareTo(data.get(i - 1)) < 1)
				Collections.swap(data, i, i-1);
		}
	}
}
