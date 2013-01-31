package com.ian.Test;

public class Chords
{
	private static final double THRESHOLD = Math.sqrt(3);
	
	private static double diameter(int n)
	{
		int count = 0;
		
		for (int i = 0; i < n; i++)
		{
			double position = 2 * Math.random() - 1;
			if (position > -0.5 && position < 0.5) count++;
		}
		
		return (double) count / n;
	}
	
	private static double twoPoint(int n)
	{
		int count = 0;
		
		for (int i = 0; i < n; i++)
		{
			double a1 = Math.random() * Math.PI * 2;
			double a2 = Math.random() * Math.PI * 2;
			
			double length = Math.sqrt(Math.pow(Math.sin(a1) - Math.sin(a2), 2) + Math.pow(Math.cos(a1) - Math.cos(a2), 2));
			
			if (length > THRESHOLD) count++;
		}
		
		return (double) count / n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Attempting 100 million 2-point tests");
		
		System.out.println("Results: " + twoPoint(100000000) * 100 + "%");
		
		System.out.println("Attempting 100 million diameter tests");
		
		System.out.println("Results: " + diameter(100000000) * 100 + "%");
	}

}
