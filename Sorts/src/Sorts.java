//----------------------------------------------------------------------------
// Sorts.java                  by Dale/Joyce/Weems                  Chapter 10
//
// Test harness used to run sorting algorithms
//
// Edited by F. Deppe 01-17-12
// Further edited by Ian Thompson 1-17-13
//----------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{
	public static final int SIZE = 50;          // Size of array to be sorted
	private static int[] values = new int[SIZE];  // Values to be sorted

	private static void initValues()
	// Initializes the values array with random integers from 0 to 99
	{
		for (int i = 0; i < SIZE; i++)
		{
			values[i] = (int) (Math.random() * 100);
		}
	}

	public static boolean isSorted()
	// Determine whether the array values are sorted
	{
		boolean sorted = true;
		for (int i = 1; i < SIZE; i++)
		{
			if (values[i] < values[i - 1])
				sorted = false;
		}
		return sorted;
	}

	public static void swap(int index1, int index2)
	// Swaps the integers at locations index1 and index2 of array values
	// Precondition:  index1 and index2 are less than size
	{
		int tmp = values[index1];
		values[index1] = values[index2];
		values[index2] = tmp;
	}

	public static void printValues()
	// Prints all the values integers
	{
//		for (int value : values)
//		{
//			System.out.print(value + " ");
//		}
//		System.out.println();
		
		int value;
		DecimalFormat fmt = new DecimalFormat("00");
		System.out.println("the values array is:");
		for (int index = 0; index < SIZE; index++)
		{
			value = values[index];
			if (((index + 1) % 10) == 0)
				System.out.println(fmt.format(value));
			else
				System.out.print(fmt.format(value) + " ");
		}
		System.out.println("Sorted: " + isSorted());
	}

	public static void insertionSort()
	//Sorts values array using the insertion sort algorithm
	//Postcondition:  values is sorted in ascending order
	{
		for(int i = 1; i < values.length; i++)
			insertItem(0, i);
	}

	public static void insertItem(int startIndex, int endIndex)
	//Inserts element at endIndex in correct position
	//Postcondition:  values is sorted between startIndex and endIndex
	{
		int current = endIndex;
		while(current > startIndex && values[current] < values[current-1])
		{
			swap(current, current - 1);
			current--;
		}
	}


	public static void main(String[] args) throws IOException
	{
		initValues();
		System.out.println("Initial values: ");
		printValues();
		mergeSort(0, SIZE - 1);
		System.out.println("Final values: ");
		printValues();
	}

	public static void selectionSort()
	// Sorts values array using the selection sort algorithm
	// Postcondition:  values is sorted in ascending order
	{
		for(int i = 0; i < SIZE - 1; i++)
		{
			swap(i, minIndex(i, SIZE-1));
		}
	}

	private static int minIndex(int startIndex, int endIndex)
	// Returns the index of the smallest value in
	// values[startIndex] . . values[endIndex]
	{
		int mindex = startIndex;
		for(int i = startIndex; i <= endIndex; i++)
		{
			if (values[i] < values[mindex])
			{
				mindex = i;
			}
		}
		return mindex;
	}
	
	public static void bubbleSort()
	{
		for (int current = 0; current < SIZE - 1; current++)
			bubbleUp(current, SIZE - 1);
	}
	
	public static void bubbleUp(int startIndex, int endIndex)
	{
		for(int index = endIndex; index > startIndex; index--)
		{
			if (values[index] < values[index-1])
				swap(index, index - 1);
		}
	}
	
	public static void mergeSort(int start, int end)
	{
		if (start != end)
		{
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			
			merge(start, mid, mid + 1, end);
		}
	}
	
	public static void merge(int leftStart, int leftEnd, int rightStart, int rightEnd)
	{
		int size = (leftEnd - leftStart + 1) + (rightEnd - rightStart + 1);
		int[] temp = new int[size];
		int leftIndex = leftStart;
		int rightIndex = rightStart;
		int tempIndex = 0;
		while (leftIndex <= leftEnd && rightIndex <= rightEnd)
		{
			if (values[leftIndex] < values[rightIndex])
			{
				temp[tempIndex] = values[leftIndex];
				tempIndex++;
				leftIndex++;
			}
			else
			{
				temp[tempIndex] = values[rightIndex];
				tempIndex++;
				rightIndex++;
			}
		}
		
		while (leftIndex <= leftEnd)
		{
			temp[tempIndex] = values[leftIndex];
			tempIndex++;
			leftIndex++;
		}
		
		while (rightIndex <= rightEnd)
		{
			temp[tempIndex] = values[rightIndex];
			tempIndex++;
			rightIndex++;
		}
		
		for (int i = 0; i < temp.length; i++)
		{
			values[leftStart + i] = temp[i];
		}
	}
}
