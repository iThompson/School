package org.team639.bracketcalc;

public class Match
{
	private MatchResult mResult;
	private Alliance mRedAlliance;
	private Alliance mBlueAlliance;
	private MatchRound mRound;
	private int mNumber;
	
	public Match(MatchRound round, int number)
	{
		mRound = round;
		mNumber = number;
	}
	
	public MatchRound getRound()
	{
		return mRound;
	}
	
	public int getNumber()
	{
		return mNumber;
	}
	
	public void setResult(MatchResult result)
	{
		mResult = result;
	}
	
	public MatchResult getResult()
	{
		return mResult;
	}
	
	public void setRedAlliance(Alliance a)
	{
		mRedAlliance = a;
	}
	
	public void setBlueAlliance(Alliance a)
	{
		mBlueAlliance = a;
	}
	
	public Alliance getRedAlliance()
	{
		return mRedAlliance;
	}
	
	public Alliance getBlueAlliance()
	{
		return mBlueAlliance;
	}
	
	public boolean hasAlliance(Alliance a)
	{
		return mRedAlliance.equals(a) || mBlueAlliance.equals(a);
	}
}
