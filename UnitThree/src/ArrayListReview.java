import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class ArrayListReview
{

	private static ArrayList<String> reverse(ArrayList<String> original)
	{
		// Init result with the final size for efficiency
		ArrayList<String> result = new ArrayList<String>(original.size());
		ListIterator<String> iter = original.listIterator(original.size());
		while (iter.hasPrevious())
		{
			result.add(iter.previous());
		}
		return result;
	}
	
	private static void filter(ArrayList<String> list1,
										ArrayList<String> list2)
	{
		Iterator<String> iter = list1.iterator();
		while (iter.hasNext())
		{
			Object val = iter.next();
			boolean found = false;
			for(Object obj : list2)
			{
				if (val == obj)
					found = true;
			}
			if (found)
				iter.remove();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList<String> testValues = new ArrayList<String>();
		testValues.add("foo");
		testValues.add("bar");
		testValues.add("baz");
		
		ArrayList<String> result = reverse(testValues);
		for (String str : result)
			System.out.println(str);
		

		ArrayList<String> testValues2 = new ArrayList<String>();
		testValues2.add("baz");
		testValues2.add("foo");
		
		System.out.println();
		filter(testValues, testValues2);
		for (String str : testValues)
			System.out.println(str);
		
		ArrayList<Object> testObj = new ArrayList<Object>();
		testObj.add(testObj);
		System.out.println(testObj.hashCode());
		ArrayList<Object> otherObj = new ArrayList<Object>();
		otherObj.add(otherObj);
		System.out.println(testObj.equals(otherObj));
	}

}
