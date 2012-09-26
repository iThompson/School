/**
 * @author ian.thompson
 *
 */
public class Car
{
	private double myTankSize;
	private double myCurrentFuel;
	private double myMilesPerGallon;
	private double myCurrentSpeed;
	
	/**
	 * Constructs the car
	 * @param tankSize The size of the fuel tank
	 * @param initialFuel The initial amount of fuel in the tank
	 * @param milesPerGallon The fuel efficiency of the car
	 */
	public Car (double tankSize, double initialFuel, double milesPerGallon)
	{
		myTankSize = tankSize;
		myCurrentFuel = initialFuel;
		myMilesPerGallon = milesPerGallon;
		myCurrentSpeed = 0.0;
		if (myCurrentFuel > myTankSize)
			myCurrentFuel = myTankSize;
	}
	
	/**
	 * Gets the size of the tank
	 * @return The size of the tank
	 */
	public double getTankSize()
	{
		return myTankSize;
	}
	
	/**
	 * Gets the current amount of fuel in the tank
	 * @return The current amount of fuel
	 */
	public double getCurrentFuel()
	{
		return myCurrentFuel;
	}
	
	/**
	 * Adds fuel to the tank
	 * @return The amount of fuel to add
	 */
	public void addFuel(double fuel)
	{
		// Don't let fuel be siphoned
		if (fuel < 0.0)
		{
			System.out.println("You can't take fuel out!");
		}
		else
		{
			myCurrentFuel += fuel;
			if (myCurrentFuel > myTankSize)
				myCurrentFuel = myTankSize;
		}
	}
	
	/**
	 * Gets the current fuel efficiency
	 * @return The fuel efficiency, in Miles Per Gallon
	 */
	public double getMilesPerGallon()
	{
		return myMilesPerGallon;
	}
	
	/**
	 * Sets the current fuel efficiency
	 * @param milesPerGallon The fuel efficiency
	 */
	public void setMilesPerGallon(double milesPerGallon)
	{
		// Can't have negative fuel efficiency
		if (milesPerGallon < 0) milesPerGallon = 0.0;
		myMilesPerGallon = milesPerGallon;
	}
	
	/**
	 * Gets the current speed of the car
	 * @return The current speed, in Miles Per Hour
	 */
	public double getSpeed()
	{
		return myCurrentSpeed;
	}
	
	/**
	 * Sets the current speed of the car
	 * @param speed The speed of the car
	 */
	public void setSpeed(double speed)
	{
		myCurrentSpeed = speed;
	}
	
	/**
	 * Returns the maximum distance that can be traveled with the current fuel
	 * @return The maximum distance
	 */
	public double getMaxDistance()
	{
		return myMilesPerGallon * myCurrentFuel;
	}
	
	/**
	 * Returns the maximum time that the car can be driven for with the current fuel
	 * @return The maximum time
	 */
	public double getMaxTime()
	{
		return getMaxDistance() / myCurrentSpeed;
	}
	
	/**
	 * Returns the distance covered over a given time
	 * @param hours The time in hours
	 */
	public double getDistanceForTime(double hours)
	{
		return myCurrentSpeed * hours;
	}
	
	/**
	 * 
	 */
	
	/**
	 * Returns how much fuel is used to travel a certain distance
	 * @param distance The distance in miles to check
	 * @return The amount of fuel which would be consumed
	 */
	public double getFuelForDistance(double distance)
	{
		// Driving backwards is the same as driving forwards
		distance = Math.abs(distance);
		
		return distance / myMilesPerGallon;
	}
	
	/**
	 * Checks if the car has enough fuel to drive a certain distance
	 * @param distance The distance in miles to check
	 * @return Whether or not the car can make it that far
	 */
	public boolean canDriveDistance(double distance)
	{
		// Driving backwards is the same as driving forwards
		distance = Math.abs(distance);
		
		return myCurrentFuel >= (distance / myMilesPerGallon);
	}
	
	/**
	 * Drives the car for a certain distance, assuming there is enough fuel
	 * @param distance The distance to attempt to travel
	 */
	public void driveDistance(double distance)
	{
		// Fuel use is the same when driving backwards
		distance = Math.abs(distance);
		
		if (canDriveDistance(distance))
		{
			myCurrentFuel -= getFuelForDistance(distance);
		}
		else
		{
			myCurrentFuel = 0.0;
		}
	}
	
	/**
	 * Drives the car for a certain amount of time, assuming there is enough fuel
	 * @param hours The time in hours to drive for
	 */
	public void driveTime(double hours)
	{
		if (hours < 0.0)
		{
			System.out.println("You can't drive for negative time!");
		}
		else
		{
			
		}
	}
}