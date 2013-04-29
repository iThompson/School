import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Calculates the number of stones required to capture a chain on a board in Go
 * @author Sunita Chrisitansen and Ian Thompson
 * @version 03/22/2013
 *
 */

public class Go
{

	/**
	 * Returns the user inputed board as an array
	 * @return the array of the board
	 */
	private static int[][] getBoard()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("How big is the board? ");
		int size;
		try
		{
			size = sc.nextInt();
		}
		catch (InputMismatchException e)
		{
			System.out.println("That's not an integer!");
			return null;
		}
		int[][] result = new int[size][size];
		sc.nextLine(); // clear out the rest of the previous line
		
		System.out.println("Input the board:");
		for(int i = 0; i < size; i++)
		{
			String line = sc.nextLine();
			if (line.length() != size)
			{
				System.out.println("That's the wrong size!");
				return null;
			}
			for (int j = 0; j < size; j++)
			{
				if (line.charAt(j) == '_')
				{
					result[i][j] = 0;
				}
				else if (line.charAt(j) == 'X')
				{
					if (i == 0 || i == size - 1 || j == 0 || j == size - 1)
					{
						System.out.println("You can't place on the edge of the grid!");
						return null;
					}
					result[i][j] = 1;
				}
				else
				{
					System.out.println("Invalid character \"" + line.charAt(j) + "\"");
					return null;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int[][] data = getBoard();
		if (data == null)
			return;
		
		int numStones = 0;
		for (int i = 0; i < data.length; i++)
		{
			for (int j = 0; j < data[i].length; j++)
			{
				if (hasAdjacent(data, i, j))
					numStones++;
			}
		}
		
		System.out.println(numStones + " stones required");
	}
	
	/**
	 * Returns whether or not an adjacent space contains a rock
	 * @param data The array representing the board
	 * @param row The row on the board
	 * @param col The column on the board
	 * @return Whether there is an adjacent rock on this space
	 */
	private static boolean hasAdjacent(int[][] data, int row, int col)
	{
		if (data[row][col] == 1)
			return false;
		if (row > 0 && data[row-1][col] == 1)
			return true;
		if (row < data.length - 1 && data[row+1][col] == 1)
			return true;
		if (col > 0 && data[row][col-1] == 1)
			return true;
		if (col < data[row].length - 1 && data[row][col + 1] == 1)
			return true;
		
		return false;
	}
}
