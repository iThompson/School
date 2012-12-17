import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixMathTest
{

	@Test
	public void testAdd()
	{
		int[][] aValues = {{1,2,3},{-4,-5,-6},{0,0,0}};
		int[][] bValues = {{-4,-5,-6},{1,2,3},{7,8,9}};
		Matrix add = MatrixMath.add(new Matrix(aValues), new Matrix(bValues));
		int[][] result = {{-3,-3,-3},{-3,-3,-3},{7,8,9}};
		assertEquals(new Matrix(result), add);
	}

	@Test
	public void testSubtract()
	{
		int[][] aValues = {{1,2,3},{-4,-5,-6},{0,0,0}};
		int[][] bValues = {{-4,-5,-6},{1,2,3},{7,8,9}};
		Matrix subtract = MatrixMath.subtract(new Matrix(aValues), new Matrix(bValues));
		int[][] result = {{5,7,9},{-5,-7,-9},{-7,-8,-9}};
		assertEquals(new Matrix(result), subtract);
	}

	@Test
	public void testMultiplyIntMatrix()
	{
		int[][] original = {{0,1,2},{3,4,5},{-6,-7,-8}};
		Matrix a = MatrixMath.multiply(-2, new Matrix(original));
		int[][] result = {{0,-2,-4},{-6,-8,-10},{12,14,16}};
		Matrix b = new Matrix(result);
		assertEquals(a, b);
	}

	@Test
	public void testMultiplyMatrixMatrix()
	{
		int[][] aValues = {{1,2,3},{4,5,6}};
		int[][] bValues = {{1,2},{-3,-4},{5,6}};
		System.out.println(new Matrix(aValues));
		System.out.println(new Matrix(bValues));
		Matrix a = MatrixMath.multiply(new Matrix(aValues), new Matrix(bValues));
		int[][] result = {{10,12},{19,24}};
		Matrix b = new Matrix(result);
		assertEquals(b, a);
	}

	@Test
	public void testTranspose()
	{
		int[][] original = {{1,2,3},{4,5,6}};
		Matrix a = MatrixMath.transpose(new Matrix(original));
		int[][] end = {{1,4},{2,5},{3,6}};
		Matrix b = new Matrix(end);
		assertEquals(a, b);
	}

}
