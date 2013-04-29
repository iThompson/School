package org.team639.bracketcalc;

public class BracketDivision {
	private MatchResult[][] m_results;
	private Alliance[] m_alliances;
	private int m_winner;
	
	private Division m_division;
	
	public BracketDivision(Division division)
	{
		m_division = division;
		
		m_results = new MatchResult[MatchRound.values().length][];
		
		for(MatchRound round : MatchRound.values())
		{
			m_results[round.getId()] = new MatchResult[round.getNumMatches()];
		}
		
		m_alliances = new Alliance[8];
		
		m_winner = -1;
	}
	
	public MatchResult getResult(MatchRound round, int match)
	{
		return m_results[round.getId()][match];
	}
	
	public void setResult(MatchRound round, int match, MatchResult result)
	{
		m_results[round.getId()][match] = result;
	}
	
	public Division getDivision()
	{
		return m_division;
	}
	
	public void setWinner(Alliance a)
	{
		Alliance myWinner = getAlliance(a.getId());
		if (myWinner == null || !myWinner.equals(a))
			throw new IllegalStateException("Winner is not in division");
		
		m_winner = a.getId();
	}
	
	public Alliance getWinner()
	{
		return (m_winner == -1 ? null : getAlliance(m_winner));
	}
	
	public void putAlliance(Alliance a)
	{
		try
		{
			m_alliances[a.getId() - 1] = a;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{}
	}
	
	public Alliance getAlliance(int id)
	{
		return m_alliances[id - 1];
	}
	
	public Alliance matchTeam(int team)
	{
		for (int i = 0; i < m_alliances.length; i++)
		{
			if (m_alliances[i] != null && m_alliances[i].containsTeam(team))
			{
				return m_alliances[i];
			}
		}
		
		return null;
	}
	
	public Alliance identifyAlliance(int main, int alt)
	{
		Alliance a = matchTeam(main);
		
		if (a != null)
			return a;
		
		// Might have taken a backup bot. Can't have more than one
		a = matchTeam(alt);
		// Don't bother checking for error, will be passed to caller anyways
		return a;
	}
}
