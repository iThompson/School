//----------------------------------------------------------------------------
// Sorts.java                  by Dale/Joyce/Weems                  Chapter 10
//
// Test harness used to run sorting algorithms
//
// Edited by F. Deppe 01-17-12
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
   	 for (int value : values)
   	 {
   		 System.out.print(value + " ");
   	 }
   	 System.out.println();
    }
    
    public static void main(String[] args) throws IOException
    {
   	 initValues();
   	 System.out.println("Initial values: ");
   	 printValues();
   	 selectionSort();
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
}
