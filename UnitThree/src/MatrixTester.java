import java.util.ArrayList;

/**
 * A class to test the Matrix and MatrixMath classes
 * @author Ian Thompson
 * @version 12.17.2012
 */
public class MatrixTester
{
	public static void main(String[] args)
	{
		int[][] valuesA = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] valuesB = {{6,2,3},{5,9,2},{1,4,3}};
		int[][] valuesC = {{1,2},{4,5},{7,8}};
		Matrix matA = new Matrix(valuesA);
		Matrix matB = new Matrix(valuesB);
		Matrix matC = new Matrix(valuesC);
		
		System.out.print("Matrix A is");
		matA.print();
		System.out.print("Matrix B is");
		matB.print();
		System.out.print("Matrix C is");
		matC.print();
		
		System.out.print("A+B =");
		MatrixMath.add(matA, matB).print();
		System.out.print("B-A =");
		MatrixMath.subtract(matB, matA).print();
		System.out.print("4*C =");
		MatrixMath.multiply(4, matC).print();
		System.out.print("A*C =");
		MatrixMath.multiply(matA, matC).print();
		System.out.print("The transpose of C is");
		MatrixMath.transpose(matC).print();
	}
}
