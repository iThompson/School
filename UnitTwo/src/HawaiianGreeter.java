
public class HawaiianGreeter extends Greeter
{

	public HawaiianGreeter(String name)
	{
		super(name);
	}

	@Override
	public String getGreeting()
	{
		return "Aloha " + getName();
	}

}
