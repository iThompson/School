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
	
	
}
