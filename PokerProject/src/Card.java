
public class Card
{
	public static final int SUIT_HEARTS = 0;
	public static final int SUIT_CLUBS = 1;
	public static final int SUIT_DIAMONDS = 2;
	public static final int SUIT_SPADES = 3;
	
	public static final int VALUE_ACE = 0;
	public static final int VALUE_TWO = 1;
	public static final int VALUE_THREE = 2;
	public static final int VALUE_FOUR = 3;
	public static final int VALUE_FIVE = 4;
	public static final int VALUE_SIX = 5;
	public static final int VALUE_SEVEN = 6;
	public static final int VALUE_EIGHT = 7;
	public static final int VALUE_NINE = 8;
	public static final int VALUE_TEN = 9;
	public static final int VALUE_JACK = 10;
	public static final int VALUE_QUEEN = 11;
	public static final int VALUE_KING = 12;
	
	public static final int SUIT_OFFSET = VALUE_KING + 1;
	
	public static final int NUM_CARDS = 52;
	
	public static final String[] SUIT_NAMES = {"Hearts",
		"Clubs",
		"Diamonds",
		"Spades"
	};
	
	public static final String[] VALUE_NAMES = {"Ace",
		"2",
		"3",
		"4",
		"5",
		"6",
		"7",
		"8",
		"9",
		"10",
		"Jack",
		"Queen",
		"King"
	};
	
	private int mCardId;
	
	/**
	 * Constructs a card given an already encoded id
	 * @param cardId The card id
	 */
	public Card(int cardId)
	{
		if (!isValidId(cardId))
			throw new IllegalArgumentException("Invalid card id");
		
		mCardId = cardId;
	}
	
	/**
	 * 
	 * @param value The numerical value of the card
	 * @param suit The suit of the card
	 */
	public Card(int value, int suit)
	{
		mCardId = buildCardId(value, suit);
	}
	
	/**
	 * Builds the card id from the value and the suit
	 * @param value The value of the card
	 * @param suit The suit of the card
	 * @return The id of the card
	 */
	public static int buildCardId(int value, int suit)
	{
		if (value < VALUE_ACE || value > VALUE_KING)
			throw new IllegalArgumentException("Invalid card value");
		if (suit < SUIT_HEARTS || suit > SUIT_SPADES)
			throw new IllegalArgumentException("Invalid card suit");
		
		return value + suit * SUIT_OFFSET;
	}
	
	/**
	 * Checks whether a card id is valid
	 * @param id The card id
	 * @return Whether the id is valid
	 */
	public static boolean isValidId(int id)
	{
		if (id < VALUE_ACE * SUIT_HEARTS || id > VALUE_KING * SUIT_SPADES)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Returns the card's id
	 * @return The card's id
	 */
	public int getId()
	{
		return mCardId;
	}
	
	/**
	 * Returns the card's value
	 * @return The card's value
	 */
	public int getValue()
	{
		return mCardId % SUIT_OFFSET;
	}
	
	/**
	 * Returns the card's suit
	 * @return The card's suit
	 */
	public int getSuit()
	{
		return mCardId / SUIT_OFFSET;
	}
	
	public String toString()
	{
		return VALUE_NAMES[getValue()] + " of " + SUIT_NAMES[getSuit()];
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + mCardId;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (mCardId != other.mCardId)
			return false;
		return true;
	}
}
