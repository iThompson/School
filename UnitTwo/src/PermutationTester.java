/**
 * Tests the Permutations class
 * @author Ian Thompson and Teddy Morris-Knower
 * @version 12.10.2012
 */
public class PermutationTester
{

	public static void main(String[] args)
	{
		int[] perm = Permutations.random(10);
		
		for (int num : perm)
		{
			System.out.print(num + " ");
		}
	}

}
