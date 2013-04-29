package org.team639.bracketcalc;

public class MatchResult {
	private boolean m_redWin;
	private boolean m_twoGame;
	private Alliance m_winner;
	
	public MatchResult(boolean redWin, boolean twoGame, Alliance winner)
	{
		m_redWin = redWin;
		m_twoGame = twoGame;
		m_winner = winner;
	}
	
	public boolean wasRedWin()
	{
		return m_redWin;
	}
	
	public boolean wasTwoGame()
	{
		return m_twoGame;
	}
	
	public Alliance getWinner()
	{
		return m_winner;
	}
	
	public String toString()
	{
		return (m_redWin ? "Red" : "Blue") + " wins in " + (m_twoGame ? "2" : "3") + " matches";
	}
}
