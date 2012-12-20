import java.util.ArrayList;
import java.util.Collections;


public class Deck
{
	private ArrayList<Card> mCards;
	
	/**
	 * Creates a standard 52 card deck, without shuffling
	 */
	public Deck()
	{
		mCards = new ArrayList<Card>(Card.NUM_CARDS);
		for (int id = 0; id < Card.NUM_CARDS; id++)
			mCards.add(new Card(id));
	}
	
	/**
	 * Randomizes the order of the cards
	 */
	public void shuffle()
	{
		Collections.shuffle(mCards);
	}
	
	/**
	 * Takes a card from the top of the deck
	 * @return The card at the top of the deck
	 */
	public Card drawCard()
	{
		if (mCards.isEmpty())
			return null;
		
		return mCards.remove(mCards.size() - 1);
	}
	
	/**
	 * Removes one instance of the card from the deck, if possible
	 * @param card The type of card to remove
	 * @return Whether a card was removed
	 */
	public boolean removeCard(Card card)
	{
		return mCards.remove(card);
	}
	
	/**
	 * Adds a card to the bottom of the deck
	 * Note that duplicates are allowed
	 * @param card The card to return
	 */
	public void returnCard(Card card)
	{
		mCards.add(0, card);
	}
	
	/**
	 * Checks whether the deck contains a certain card
	 * @param card The card to find
	 * @return Whether the deck contains that card
	 */
	public boolean hasCard(Card card)
	{
		return mCards.contains(card);
	}
	
	/**
	 * Returns the number of cards in the deck
	 * @return The number of cards in the deck
	 */
	public int getSize()
	{
		return mCards.size();
	}
}
