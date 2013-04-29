package org.team639.bracketcalc;

public class BracketEinstein
{
	private Alliance[] m_alliances;
	private MatchResult[][] m_results;
	private Division m_winner;
	
	public BracketEinstein()
	{
		m_alliances = new Alliance[Division.values().length];
		m_results = new MatchResult[MatchRound.values().length][];
		for (MatchRound round : MatchRound.values())
		{
			if (!round.equals(MatchRound.QUARTER))
			{
				m_results[round.getId()] = new MatchResult[round.getNumMatches()];
			}
		}
	}
	
	public void setAlliance(Division div, Alliance a)
	{
		m_alliances[div.getId()] = a;
	}
	
	public Alliance getAlliance(Division div)
	{
		return m_alliances[div.getId()];
	}
	
	public void setWinner(Alliance aWin)
	{
		m_winner = Division.byId(aWin.getId() - 1);
	}
	
	public Division getWinner()
	{
		return m_winner;
	}
	
	public Alliance getWinningAlliance()
	{
		return getAlliance(m_winner);
	}
	
	public void setResult(MatchRound round, int match, MatchResult result)
	{
		if (round.equals(MatchRound.QUARTER))
			throw new IllegalArgumentException("No QF in Einstein");
		m_results[round.getId()][match] = result;
	}
	
	public MatchResult getResult(MatchRound round, int match)
	{
		if (round.equals(MatchRound.QUARTER))
			throw new IllegalArgumentException("No QF in Einstein");
		return m_results[round.getId()][match];
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
