import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/**
 * Represents a hand of 5 cards
 * @author Ian Thompson
 */
public class Hand
{
	public static int HAND_SIZE = 5;
	private ArrayList<Card> mCards;
	
	/**
	 * Initializes an empty hand
	 */
	public Hand()
	{
		mCards = new ArrayList<Card>();
	}
	
	/**
	 * Draws cards from the deck until the hand has 5 cards
	 * @param deck The deck to draw from
	 */
	public void fill(Deck deck)
	{
		while (mCards.size() < HAND_SIZE)
		{
			mCards.add(deck.drawCard());
		}
	}
	
	/**
	 * Gets a card held in the hand
	 * @param index The index of the card
	 * @return The card at index
	 */
	public Card getCard(int index)
	{
		if (index >= mCards.size())
			throw new IllegalArgumentException("Don't have that card");
		
		return mCards.get(index);
	}
	
	/**
	 * Returns an array of all cards in the hand
	 * @return An array of all cards in the hand
	 */
	public ArrayList<Card> getCards()
	{
		return (ArrayList<Card>) mCards.clone();
	}
	
	/**
	 * Removes cards from the hand, based on the provided indices
	 * @param indices A list of indices to remove from the hand
	 */
	public void removeCards(ArrayList<Integer> indices)
	{
		Collections.sort(indices);
		ListIterator<Integer> it = indices.listIterator(indices.size());
		while(it.hasPrevious())
		{
			int toRemove = it.previous();
			mCards.remove(toRemove);
		}
	}
	
	/**
	 * Calculates the score of the hand
	 * @return The score of the hand
	 */
	public Score checkScore()
	{
		if (mCards.size() != HAND_SIZE)
			throw new IllegalStateException("Not enough cards");
		
		Collections.sort(mCards);
		if (mCards.get(0).getValue() == Card.VALUE_ACE
				&& mCards.get(1).getValue() != Card.VALUE_TWO)
		{
			mCards.add(mCards.remove(0));
		}
		
		boolean flush = hasFlush();
		boolean straight = hasStraight();
		boolean fourKind = hasFourKind();
		boolean threeKind = hasThreeKind();
		int pairs = countPairs();
		
		if (flush && straight)
		{
				if (mCards.get(0).getValue() == Card.VALUE_TEN)
					return new Score(Score.ROYAL_FLUSH);
				else
					return new Score(Score.STRAIGHT_FLUSH);
		}
		
		if (fourKind)
			return new Score(Score.FOUR_KIND);
		
		if (threeKind && pairs == 1)
			return new Score(Score.FULL_HOUSE);
		
		if (flush)
			return new Score(Score.FLUSH);
		
		if (straight)
			return new Score(Score.STRAIGHT);
		
		if (threeKind)
			return new Score(Score.THREE_KIND);
		
		if (pairs == 2)
			return new Score(Score.TWO_PAIR);
		
		if (pairs == 1)
			return new Score(Score.ONE_PAIR);
		
		return new Score(Score.NO_PAIR);
	}
	
	/**
	 * Determines the number of cards in a set beginning at the index
	 * @param index The index to start looking at
	 * @return The number of cards with the same value
	 */
	private int countSet(int index)
	{
		int count = 0;
		int value = mCards.get(index).getValue();
		while (index + count < HAND_SIZE
				&& mCards.get(index + count).getValue() == value)
		{
			count++;
		}
		
		return count;
	}
	
	/**
	 * Returns whether the hand contains a flush
	 * @return Whether the hand contains a flush
	 */
	private boolean hasFlush()
	{
		int suit = mCards.get(0).getSuit();
		for (Card card : mCards)
		{
			if (card.getSuit() != suit)
				return false;
		}
		return true;
	}
	
	/**
	 * Returns whether the hand contains a straight
	 * @return Whether the hand contains a straight
	 */
	private boolean hasStraight()
	{
		int baseValue = mCards.get(0).getValue();
		for (int i = 0; i < HAND_SIZE; i++)
		{
			Card card = mCards.get(i);
			// Special case for Aces, which will have value 0
			int value = baseValue + i;
			if (value == Card.VALUE_KING + 1)
				value = Card.VALUE_ACE;
			
			if (card.getValue() != value)
				return false;
		}
		
		return true;
	}
	
	/**
	 * Returns whether the hand contains a 4 of a kind
	 * @return Whether the hand contains a 4 of a kind
	 */
	private boolean hasFourKind()
	{
		if (countSet(0) == 4 || countSet(1) == 4)
			return true;
		
		return false;
		
	}
	
	/**
	 * Returns whether the hand contains a 3 of a kind
	 * @return Whether the hand contains a 3 of a kind
	 */
	private boolean hasThreeKind()
	{
		for (int i = 0; i < HAND_SIZE - 2; i++)
			if (countSet(i) == 3)
				return true;
		
		return false;
	}
	
	/**
	 * Counts the number of pairs in the hand
	 * @return The number of pairs in the hand
	 */
	private int countPairs()
	{
		int i = 0;
		int count = 0;
		while (i < HAND_SIZE)
		{
			int setLength = countSet(i);
			if (setLength == 2)
				count++;
			i += setLength;
		}
		
		return count;
	}
}
