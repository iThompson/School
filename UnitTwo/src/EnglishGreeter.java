
public class EnglishGreeter extends Greeter
{

	public EnglishGreeter(String name)
	{
		super(name);
	}

	@Override
	public String getGreeting()
	{
		return "Hello " + getName();
	}

}
