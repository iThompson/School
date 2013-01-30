
public class Score
{
	public static final int NO_PAIR = 0;
	public static final int ONE_PAIR = 1;
	public static final int TWO_PAIR = 2;
	public static final int THREE_KIND = 3;
	public static final int STRAIGHT = 4;
	public static final int FLUSH = 5;
	public static final int FULL_HOUSE = 6;
	public static final int FOUR_KIND = 7;
	public static final int STRAIGHT_FLUSH = 8;
	public static final int ROYAL_FLUSH = 9;
	
	private static final String[] names = {"No Pair",
														"One Pair",
														"Two Pair",
														"Three of a Kind",
														"Straight",
														"Flush",
														"Full House",
														"Four of a Kind",
														"Straight Flush",
														"Royal Flush"};
	
	private int mScore;
	
	/**
	 * Creates a score object with the given score
	 * @param score The score to initialize to
	 */
	public Score(int score)
	{
		if (score < NO_PAIR || score > ROYAL_FLUSH)
			throw new IllegalArgumentException("Invalid score");
		mScore = score;
	}
	
	/**
	 * Returns the score
	 * @return The score
	 */
	public int getScore()
	{
		return mScore;
	}
	
	/**
	 * Returns the name of the score
	 * @return The name of the score
	 */
	public String getName()
	{
		return names[mScore];
	}
	
	/**
	 * Returns a string representing the score
	 * @return A string representing the score
	 */
	public String toString()
	{
		return getName();
	}
}
