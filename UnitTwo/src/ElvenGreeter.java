
public class ElvenGreeter extends Greeter
{

	public ElvenGreeter(String name)
	{
		super(name);
	}

	@Override
	public String getGreeting()
	{
		return "Saesa omnetien lle " + getName();
	}

}
