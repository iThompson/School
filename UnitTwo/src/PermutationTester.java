
public class PermutationTester
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] perm = Permutations.random(10);
		
		for (int num : perm)
		{
			System.out.print(num + " ");
		}
	}

}
