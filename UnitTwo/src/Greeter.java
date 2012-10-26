public abstract class Greeter
{
	private String mName;
	
	/**
	 * Constructs a Greeter, given a user's name
	 * @param name The user's name
	 */
	public Greeter(String name)
	{
		mName = name;
	}
	
	/**
	 * Returns the user's name
	 * @return The user's name
	 */
	public String getName()
	{
		return mName;
	}
	
	/**
	 * Returns a greeting string
	 * @return A greeting string
	 */
	public abstract String getGreeting();
}
