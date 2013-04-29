package org.team639.bracketcalc;

public enum MatchRound {
	QUARTER(0, 4, "QF"),
	SEMI(1, 2, "SF"),
	FINAL(2, 1, "F");
	
	private int id;
	private int num;
	private String prefix;
	
	private MatchRound(int id, int numMatches, String prefix)
	{
		this.id = id;
		this.num = numMatches;
		this.prefix = prefix;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getPrefix()
	{
		return prefix;
	}
	
	public int getNumMatches()
	{
		return num;
	}
}
