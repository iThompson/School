import junit.framework.TestCase;


public class CardTest extends TestCase
{

	public void testCardInt()
	{
		Card card = new Card(15);
		assertEquals(15, card.getId());
		
		assertEquals(Card.VALUE_THREE, card.getValue());
		assertEquals(Card.SUIT_CLUBS, card.getSuit());
	}

	public void testCardIntInt()
	{
		Card card = new Card(Card.VALUE_FIVE, Card.SUIT_CLUBS);
		
		assertEquals(Card.VALUE_FIVE, card.getValue());
		assertEquals(Card.SUIT_CLUBS, card.getSuit());
		assertEquals(Card.buildCardId(Card.VALUE_FIVE, Card.SUIT_CLUBS), card.getId());
	}

	public void testBuildCardId()
	{
		int id = Card.buildCardId(Card.VALUE_EIGHT, Card.SUIT_DIAMONDS);
		
		assertEquals(33, id);
	}

	public void testIsValidId()
	{
		assertFalse(Card.isValidId(-1));
		assertTrue(Card.isValidId(0));
		assertTrue(Card.isValidId(27));
		assertTrue(Card.isValidId(51));
		assertFalse(Card.isValidId(52));
	}

	public void testEquals()
	{
		Card cardA = new Card(Card.VALUE_FIVE, Card.SUIT_CLUBS);
		Card cardB = new Card(17);
		Card cardC = new Card(27);
		Card cardD = new Card(Card.VALUE_TWO, Card.SUIT_SPADES);
		
		assertEquals(cardA, cardB);
		assertFalse(cardA.equals(cardC));
		assertFalse(cardC.equals(cardD));
	}

}
