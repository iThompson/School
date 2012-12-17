import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest
{

	@Test
	public void testMatrixEmptyConstructor()
	{
		Matrix a = new Matrix(2, 3);
		int[][] values = {{0, 0, 0},{0, 0, 0}};
		Matrix b = new Matrix(values);
		assertEquals(a, b);
	}

	@Test
	public void testMatrixIntArrayArray()
	{
		int[][] values = new int[3][4];
		values[1][2] = 42;
		Matrix a = new Matrix(values);
		assertEquals(42, a.get(1,2));
		
	}

	@Test
	public void testGetRows()
	{
		Matrix a = new Matrix(2,3);
		assertEquals(2, a.getRows());
		int[][] values = {{1,2,3},{4,5,6}};
		Matrix b = new Matrix(values);
		assertEquals(2, b.getRows());
	}

	@Test
	public void testGetCols()
	{
		Matrix a = new Matrix(2,3);
		assertEquals(3, a.getCols());
		int[][] values = {{1,2,3},{4,5,6}};
		Matrix b = new Matrix(values);
		assertEquals(3, b.getCols());
	}
	
	@Test
	public void testDeterminant()
	{
		int[][] values = {{1,2,3,10},{17,5,6,77},{7,8,9,2},{12,27,16,5}};
		Matrix a = new Matrix(values);
		assertEquals(25142, a.determinant());
	}
	
	@Test
	public void test1x1Determinant()
	{
		int[][] values = {{42}};
		Matrix a = new Matrix(values);
		assertEquals(42, a.determinant());
	}

	@Test
	public void testToString()
	{
		int[][] values = {{1,2,3},{2,3,4}};
		Matrix a = new Matrix(values);
		String result = "1 2 3 \n2 3 4 \n";
		assertEquals(result, a.toString());
	}
	
	@Test
	public void testIdentity()
	{
		int[][] identity = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		Matrix expected = new Matrix(identity);
		assertEquals(expected, Matrix.identity(4));
		
		int[][] testValues = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Matrix original = new Matrix(testValues);
		Matrix result = MatrixMath.multiply(original, Matrix.identity(4));
		assertEquals(original, result);
	}

}
