import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Plays a game of Poker on the console
 * @author Ian Thompson
 */
public class ConsolePokerGame extends PokerGame
{

	/**
	 * Reports the contents of the hand to the user
	 * @param hand The hand to report
	 */
	@Override
	protected void printHand(Hand hand)
	{
		ArrayList<Card> cards = hand.getCards();
		for (int i = 0; i < cards.size(); i++)
		{
			System.out.println(i + ": " + cards.get(i));
		}
	}

	/**
	 * Asks the user for which cards to remove from the hand
	 * @return The indices that should be removed
	 */
	@Override
	protected ArrayList<Integer> getRejections()
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> result = new ArrayList<Integer>();
		System.out.print("How many cards will you remove? ");
		try {
			int numCards = sc.nextInt();
			if (numCards < 0 || numCards > Hand.HAND_SIZE)
			{
				System.out.println("You can't take " + numCards + " out!");
				sc.close();
				return null;
			}
			
			System.out.print("Select " + numCards + " cards to remove: ");
			for (int i = 0; i < numCards; i++)
			{
				int input = sc.nextInt();
				if (input < 0 || input >= Hand.HAND_SIZE)
				{
					System.out.println(input + " is not a valid card");
					sc.close();
					return null;
				}
				result.add(input);				
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("That wasn't an integer!");
			sc.close();
			return null;
		}

		sc.close();
		return result;
	}

	/**
	 * Reports the score of the hand to the user
	 * @param score The score of the hand
	 */
	@Override
	protected void printScore(Score score)
	{
		System.out.println("Your score is: " + score);

	}

	/**
	 * Asks the user if another game should be played
	 * @return Whether another game should be played
	 */
	@Override
	protected boolean askReplay()
	{
		return false;
	}

	public static void main(String[] args)
	{
		PokerGame game = new ConsolePokerGame();
		game.runGame();

	}

}
