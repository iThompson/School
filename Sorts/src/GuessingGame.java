import java.util.InputMismatchException;
import java.util.Scanner;


public class GuessingGame
{
	private static final int MAX_TRIES = 15;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("1 for human guess, 2 for computer guess: ");
		int response;
		try
		{
			response = sc.nextInt();
		}
		catch (InputMismatchException e)
		{
			System.out.println("That's not a number!");
			return;
		}
		if (response == 1)
		{
			runHumanGuess(sc);
		}
		else if (response == 2)
		{
			runComputerGuess(sc);
		}
		else
		{
			System.out.println("That's not a valid response!");
		}
		sc.close();
	}

	public static void runHumanGuess(Scanner sc)
	{
		int max = 100;
		int min = 0;
		int tries = 0;
		int number = (int) (Math.random() * 100);
		boolean found = false;
		
		System.out.println("I'm thinking of a number between 0 and 100, inclusive");
		while(!found && tries < MAX_TRIES)
		{
			System.out.print("What's your guess? ");
			int guess;
			tries++;
			try
			{
				guess = sc.nextInt();
				if (guess < min)
				{
					System.out.println("You know that's too low!");
				}
				else if (guess > max)
				{
					System.out.println("You know that's too high!");
				}
				else if (guess > number)
				{
					System.out.println("Too high");
					max = guess - 1;
				}
				else if (guess < number)
				{
					System.out.println("Too low");
					min = guess + 1;
				}
				else
				{
					found = true;
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("You suck at typing numbers. Lose the game");
				return;
			}
		}
		if (found)
		{
			System.out.println("You win in " + tries + " tries");
		}
		else
		{
			System.out.println("Haha, you lose! The number was " + number);
		}
	}
	
	public static void runComputerGuess(Scanner sc)
	{
		int max = 100;
		int min = 0;
		int tries = 0;
		boolean found = false;
		
		System.out.println("Pick a number from 0 to 100, inclusive");
		while (!found && tries < MAX_TRIES)
		{
			int guess = (min + max) / 2;
			System.out.println("My guess is " + guess);
			System.out.print("Type c if correct, l if too low, h if too high: ");
			String response = sc.next();
			if (response.equalsIgnoreCase("c"))
			{
				found = true;
			}
			else if (response.equalsIgnoreCase("l"))
			{
				if (guess + 1 > max)
				{
					System.out.println("Liar!");
					return;
				}
				else
				{
					min = guess + 1;
				}
			}
			else if (response.equalsIgnoreCase("h"))
			{
				if (guess - 1 < min)
				{
					System.out.println("Liar!");
					return;
				}
				else
				{
					max = guess - 1;
				}
			}
			else
			{
				System.out.println("That's not a valid response!");
				tries--;
			}
			tries++;
		}
		
		if (found)
		{
			System.out.println("I won in " + tries + " tries!");
		}
		else
		{
			System.out.println("You beat me :(");
		}
	}
	
}
