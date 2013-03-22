import java.util.Scanner;

/**
 * Determines the angle between the hour hand and minute hand
 * @author Ian Thompson and Sunita Christiansen
 * @version 03/22/2013
 *
 */
public class AnalogAngles
{
	/**
	 * Determine the angle between the hands, given the hour and minute
	 * @param hour The current hour
	 * @param minute The current minute
	 * @return The angle between the hands
	 */
	private static double calcAngle(int hour, int minute)
	{
		double hourAngle = (30.0 * hour) + (0.5 * minute);
		double minuteAngle = 6.0 * minute;
		
		double result = Math.abs(hourAngle - minuteAngle);
		if (result > 180.0)
		{
			result = 360.0 - result;
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while (sc.hasNextInt())
		{
			int hour;
			int minute;
			
			hour = sc.nextInt();
			minute = sc.nextInt();
			
			System.out.println(calcAngle(hour, minute));
		}
	}

}
