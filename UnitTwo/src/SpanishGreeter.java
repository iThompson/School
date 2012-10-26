
public class SpanishGreeter extends Greeter
{

	public SpanishGreeter(String name)
	{
		super(name);
	}

	@Override
	public String getGreeting()
	{
		return "Hola " + getName();
	}

}
