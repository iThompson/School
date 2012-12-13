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
		Matrix a = new Matrix(2,3);
		assertTrue(a.getRows() == 2);
		int[][] values = {{1,2,3},{4,5,6}};
		Matrix b = new Matrix(values);
		assertTrue(b.getRows() == 2);
	}

	@Test
	public void testGetCols()
	{
		Matrix a = new Matrix(2,3);
		assertTrue(a.getCols() == 3);
		int[][] values = {{1,2,3},{4,5,6}};
		Matrix b = new Matrix(values);
		assertTrue(b.getCols() == 3);
	}
	
	@Test
	public void testDeterminant()
	{
		int[][] values = {{1,2,3,10},{17,5,6,77},{7,8,9,2},{12,27,16,5}};
		Matrix a = new Matrix(values);
//		assertTrue(a.determinant() == 78);
		assertEquals(25142, a.determinant());
	}

	@Test
	public void testToString()
	{
		fail("Not yet implemented");
	}

}
