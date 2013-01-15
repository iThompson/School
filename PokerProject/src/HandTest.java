import junit.framework.TestCase;


public class HandTest extends TestCase
{
	public void testRoyalFlush()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;

		deck.returnCard(new Card(Card.VALUE_ACE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_QUEEN, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_KING, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_JACK, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TEN, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.ROYAL_FLUSH, result.getScore());
	}

	public void testStraightFlush()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		// Straight Flush
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_FIVE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_SIX, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_THREE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.STRAIGHT_FLUSH, result.getScore());
	}
	
	public void testFourKind()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_DIAMONDS));
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_HEARTS));
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_SPADES));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.FOUR_KIND, result.getScore());
	}
	
	public void testFullHouse()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_SPADES));
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_DIAMONDS));
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_HEARTS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.FULL_HOUSE, result.getScore());
	}
	
	public void testFlush()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_FIVE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_SIX, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_SEVEN, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.FLUSH, result.getScore());
	}
	
	public void testStraight()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_DIAMONDS));
		deck.returnCard(new Card(Card.VALUE_FIVE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_SIX, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_THREE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.STRAIGHT, result.getScore());
	}
	
	public void testThreeKind()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_DIAMONDS));
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_HEARTS));
		deck.returnCard(new Card(Card.VALUE_THREE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.THREE_KIND, result.getScore());
	}
	
	public void testTwoPair()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_SIX, Card.SUIT_HEARTS));
		deck.returnCard(new Card(Card.VALUE_SIX, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_SPADES));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_DIAMONDS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.TWO_PAIR, result.getScore());
	}
	
	public void testPair()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_HEARTS));
		deck.returnCard(new Card(Card.VALUE_SIX, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_THREE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.ONE_PAIR, result.getScore());
	}
	
	public void testNoPair()
	{
		Deck deck = new Deck();
		deck.emptyDeck();
		Hand hand = new Hand();
		Score result;
		
		deck.returnCard(new Card(Card.VALUE_FOUR, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_FIVE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_QUEEN, Card.SUIT_SPADES));
		deck.returnCard(new Card(Card.VALUE_THREE, Card.SUIT_CLUBS));
		deck.returnCard(new Card(Card.VALUE_TWO, Card.SUIT_CLUBS));
		hand.fill(deck);
		result = hand.checkScore();
		assertEquals(Score.NO_PAIR, result.getScore());
	}

}
