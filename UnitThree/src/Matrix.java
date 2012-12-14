import java.util.Arrays;


public class Matrix
{
	private int[][] mData;
	
	public Matrix(int row, int col)
	{
		mData = new int[row][col];
	}
	
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
	
	public void loadValues(int[][] values)
	{
		if (values.length != getRows())
				throw new IllegalArgumentException("Wrong row count!");
		for (int[] valueRow : values)
			if (valueRow.length != getCols())
				throw new IllegalArgumentException("Wrong column count!");
		
		mData = values;
	}
	
	public int get(int row, int col)
	{
		return mData[row][col];
	}
	
	public int getRows()
	{
		return mData.length;
	}
	
	public int getCols()
	{
		return mData[0].length;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mData);
		return result;
	}

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
	
	public void print()
	{
		System.out.println();
		System.out.println(this);
	}
	
	public int determinant()
	{
		if (getCols() != getRows())
			throw new IllegalStateException("Not a square matrix!");
		
		int[] cols = new int[getCols()];
		for (int i = 0; i < cols.length; i++)
			cols[i] = i;
		
		return determinantSub(cols);
	}
	
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
	
}
