
public class GermanGreeter extends Greeter
{

	public GermanGreeter(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getGreeting()
	{
		return "Hallo " + getName();
	}

}
