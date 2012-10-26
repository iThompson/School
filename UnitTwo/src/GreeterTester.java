import java.util.Scanner;


public class GreeterTester
{
	private static void testGreeter(Greeter greet)
	{
		System.out.println(greet.getGreeting());
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		
		testGreeter(new EnglishGreeter(name));
		testGreeter(new ElvenGreeter(name));
		testGreeter(new GermanGreeter(name));
		testGreeter(new HawaiianGreeter(name));
		testGreeter(new NyanGreeter(name));
		testGreeter(new SpanishGreeter(name));
	}

}
