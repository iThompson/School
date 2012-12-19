import java.util.ArrayList;
import java.util.Collections;


public class Deck
{
	private ArrayList<Card> mCards;
	
	public Deck()
	{
		mCards = new ArrayList<Card>(Card.NUM_CARDS);
		for (int id = 0; id < Card.NUM_CARDS; id++)
			mCards.add(new Card(id));
	}
	
	public void shuffle()
	{
		Collections.shuffle(mCards);
	}
}
