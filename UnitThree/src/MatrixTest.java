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
		assertTrue(a.equals(b));
	}

	@Test
	public void testMatrixIntArrayArray()
	{
		int[][] values = new int[3][4];
		values[1][2] = 42;
		Matrix a = new Matrix(values);
		assertTrue(a.get(1,2) == 42);
		
	}

	@Test
	public void testGetRows()
	{
		
	}

	@Test
	public void testGetCols()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testToString()
	{
		fail("Not yet implemented");
	}

}
