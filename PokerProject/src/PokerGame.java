import java.util.ArrayList;

/**
 * A class which runs a Poker game
 * @author Ian Thompson
 */
public abstract class PokerGame
{
	/**
	 * Runs the game of poker
	 */
	protected void runGame()
	{
		do
		{
		Deck deck = new Deck();
		deck.shuffle();
		Hand hand = new Hand();
		hand.fill(deck);
		printHand(hand);
		
		ArrayList<Integer> rejections = getRejections();
		hand.removeCards(rejections);
		hand.fill(deck);
		
		printHand(hand);
		printScore(hand.checkScore());
		}
		while (askReplay());
	}
	
	/**
	 * Reports the contents of the hand to the user
	 * @param hand The hand to report
	 */
	protected abstract void printHand(Hand hand);
	
	/**
	 * Asks the user for which cards to remove from the hand
	 * @return The indices that should be removed
	 */
	protected abstract ArrayList<Integer> getRejections();
	
	/**
	 * Reports the score of the hand to the user
	 * @param score The score of the hand
	 */
	protected abstract void printScore(Score score);
	
	/**
	 * Asks the user if another game should be played
	 * @return Whether another game should be played
	 */
	protected abstract boolean askReplay();
}
