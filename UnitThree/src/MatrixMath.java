
public class MatrixMath
{
	public static Matrix add(Matrix a, Matrix b)
	{
		if (a.getRows() != b.getRows() || a.getCols() != b.getCols())
			throw new IllegalArgumentException("Matrix size mismatch");
		
		int[][] newValues = new int[a.getRows()][a.getCols()];
		for (int i = 0; i < a.getRows(); i++)
			for (int j = 0; j < a.getCols(); j++)
				newValues[i][j] = a.get(i, j) + b.get(i, j);
		
		return new Matrix(newValues);
	}
	
	public static Matrix subtract(Matrix a, Matrix b)
	{
		if (a.getRows() != b.getRows() || a.getCols() != b.getCols())
			throw new IllegalArgumentException("Matrix size mismatch");
		
		int[][] newValues = new int[a.getRows()][a.getCols()];
		for (int i = 0; i < a.getRows(); i++)
			for (int j = 0; j < a.getCols(); j++)
				newValues[i][j] = a.get(i, j) - b.get(i, j);
		
		return new Matrix(newValues);
	}
	
	public static Matrix multiply(int a, Matrix b)
	{	
		int[][] newValues = new int[b.getRows()][b.getCols()];
		for (int i = 0; i < b.getRows(); i++)
			for (int j = 0; j < b.getCols(); j++)
				newValues[i][j] = a * b.get(i, j);
		
		return new Matrix(newValues);
	}
	
	public static Matrix multiply(Matrix a, Matrix b)
	{
		if (a.getCols() != b.getRows())
			throw new IllegalArgumentException("Matrix size mismatch");
		
		int[][] newValues = new int[a.getRows()][b.getCols()];
		for (int i = 0; i < a.getRows(); i++)
			for (int j = 0; j < b.getCols(); j++)
			{
				newValues[i][j] = 0;
				for (int term = 0; term < a.getCols(); term++)
					newValues[i][j] += a.get(i, term) * b.get(term, i);
			}
		
		return new Matrix(newValues);
	}
	
	public static Matrix transpose(Matrix mat)
	{
		int[][] newValues = new int[mat.getCols()][mat.getRows()];
		
		for (int i = 0; i < mat.getCols(); i++)
			for (int j = 0; j < mat.getRows(); j++)
				newValues[i][j] = mat.get(j, i);
		
		return new Matrix(newValues);
	}
}
