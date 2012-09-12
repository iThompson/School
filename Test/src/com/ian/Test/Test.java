package com.ian.Test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, world!");
		
		System.out.println(intSum(5));
		System.out.println(intSum(1));
		System.out.println(intSum(0));
		System.out.println(intSum(-4));
	}
	
	/**
	 * Calculates the sum of all numbers from 1 to n
	 * @param n The end number
	 * @return The sum from 1 to n
	 */
	public static int intSum(int n)
	{
		int sum = 0;
		
		if (n < 1)
		{ // Counting backwards
			for(int i = 1; i >= n; i--)
				sum += i;
		}
		else
		{ // Counting forwards
			for(int i = 1; i <= n; i++)
				sum += i;
		}
		
		return sum;
	}

}
