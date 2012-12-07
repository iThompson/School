
public class Permutations
{

	private static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] random(int n)
	{
		int[] result = new int[n];
		for (int i = 0; i < n; i++)
		{
			result[i] = i + 1;
		}
		
		for (int i = n - 1; i > 0; i--)
		{
			swap(result, (int) (Math.random() * i), i);
		}
		
		return result;
	}
}
