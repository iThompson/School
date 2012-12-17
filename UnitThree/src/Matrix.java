import java.util.Arrays;

/**
 * A class which represents an immutable matrix
 * @author Ian Thompson
 * @version 12.17.2012
 */
public class Matrix
{
	private int[][] mData;
	
	/**
	 * Creates a matrix of 0s with the given size
	 * @param row The number of rows
	 * @param col The number of columns
	 */
	public Matrix(int row, int col)
	{
		mData = new int[row][col];
	}
	
	/**
	 * Creates a matrix with the provided values
	 * @param values The matrix values, in [row][column] order
	 */
	public Matrix(int[][] values)
	{
		int rowSize = values[0].length;
		for (int[] valueRow : values)
		{
			if (valueRow.length != rowSize)
				throw new IllegalArgumentException("Non-rectangular array!");
		}
		int rows = values.length;
		
		// Don't use Arrays.copyOf, since it is only a shallow copy
		mData = new int[rows][rowSize];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < rowSize; j++)
				mData[i][j] = values[i][j];
	}
	
	/**
	 * Returns a value from the matrix
	 * @param row The row of the value
	 * @param col The column of the value
	 * @return The value
	 */
	public int get(int row, int col)
	{
		return mData[row][col];
	}
	
	/**
	 * Returns the number of rows in the matrix
	 * @return The number of rows in the matrix
	 */
	public int getRows()
	{
		return mData.length;
	}
	
	/**
	 * Returns the number of columns in the matrix
	 * @return The number of columns in the matrix
	 */
	public int getCols()
	{
		return mData[0].length;
	}

	/**
	 * Returns a hash for this matrix
	 * @return A hash for this matrix
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mData);
		return result;
	}

	/**
	 * Tests for equality with another matrix
	 * @param obj The other matrix
	 * @return whether the two are equals
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
		Matrix other = (Matrix) obj;
		if (!Arrays.deepEquals(mData, other.mData))
			return false;
		return true;
	}

	/**
	 * Returns a String representing this matrix
	 * @return A String representing this matrix
	 */
	@Override
	public String toString()
	{
		String result = "";
		for (int[] row : mData)
		{
			for (int value : row)
				result += value + " ";
			result += "\n";
		}
		
		return result;
	}
	
	/**
	 * Prints this Matrix to the console
	 */
	public void print()
	{
		System.out.println();
		System.out.println(this);
	}
	
	/**
	 * Returns the determinant of the matrix
	 * @return The determinant of the matrix
	 */
	public int determinant()
	{
		if (getCols() != getRows())
			throw new IllegalStateException("Not a square matrix!");
		
		int[] cols = new int[getCols()];
		for (int i = 0; i < cols.length; i++)
			cols[i] = i;
		
		return determinantSub(cols);
	}
	
	/**
	 * Recursive helper method for calculating the determinant
	 * @param cols The columns of the sub-matrix currently being calculated
	 * @return The determinant of the sub-matrix indicated by cols
	 */
	private int determinantSub(int[] cols)
	{
		if (cols.length == 1) // Only occurs if mData is a 1x1 matrix
			return mData[0][0];
		else if (cols.length == 2)
		{
			int bottomRow = mData.length - 1;
			return mData[bottomRow - 1][cols[0]] * mData[bottomRow][cols[1]]
					- mData[bottomRow - 1][cols[1]] * mData[bottomRow][cols[0]];
		}
		else
		{
			int result = 0;
			int[] subCols = new int[cols.length - 1];
			for (int unusedIndex = 0; unusedIndex < cols.length; unusedIndex++)
			{
				int i;
				for (i = 0; i < unusedIndex; i++)
					subCols[i] = cols[i];
				for (; i < subCols.length; i++)
					subCols[i] = cols[i + 1];
				
				if (unusedIndex % 2 == 0)
				{
					result += mData[mData.length - cols.length][cols[unusedIndex]]
									* determinantSub(subCols);
				}
				else
				{
					result -= mData[mData.length - cols.length][cols[unusedIndex]]
									* determinantSub(subCols);
				}
			}
			return result;
		}
	}
	
	/**
	 * Creates a square nxn identity matrix
	 * @param n The dimensions of the matrix
	 * @return A square identity matrix of nxn size
	 */
	public static Matrix identity(int n)
	{
		int[][] values = new int[n][n];
		for (int i = 0; i < n; i++)
			values[i][i] = 1;
		
		return new Matrix(values);
	}
}
