/**
 * A class used to generate a randomly permutation of an array
 * @author Ian Thompson and Teddy Morris-Knower
 * @version 12.10.2012
 */
public class Permutations
{
	/**
	 * Swaps elements i and j in the array arr
	 * @param arr The array to swap in
	 * @param i The 1st element to swap
	 * @param j The 2nd element to swap
	 */
	private static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * Returns an array of randomly ordered integers from 1 to n
	 * @param n The number of elements in the array
	 * @return A randomly ordered array of ints from 1 to n
	 */
	public static int[] random(int n)
	{
		int[] result = new int[n];
		for (int i = 0; i < n; i++)
		{
			result[i] = i + 1;
		}
		
		for (int i = n - 1; i > 0; i--)
		{
			swap(result, (int) (Math.random() * (i + 1)), i);
		}
		
		return result;
	}
}
