package org.team639.bracketcalc;

import java.util.ArrayList;
import java.util.Arrays;

public class Alliance
{
	private int[] m_teams;
	private int m_id;
	private ArrayList<AllianceChangeListener> m_listeners;
	
	public Alliance(int id)
	{
		m_id = id;
		m_teams = new int[3];
		m_listeners = new ArrayList<AllianceChangeListener>();
	}
	
	public void setTeam(int slot, int team)
	{
		if (slot < 0 || slot > 2)
			throw new IllegalArgumentException("Bad team slot");
		
		m_teams[slot] = team;
		
		fireAllianceModified();
	}
	
	public int getTeam(int slot)
	{
		if (slot < 0 || slot > 2)
			throw new IllegalArgumentException("Bad team slot");
		
		return m_teams[slot];
	}
	
	public int getId()
	{
		return m_id;
	}
	
	public boolean containsTeam(int team)
	{
		for (int aTeam : m_teams)
		{
			if (aTeam == team)
			{
				return true;
			}
		}
		return false;
	}
	
	public void addChangeListener(AllianceChangeListener listener)
	{
		m_listeners.add(listener);
	}
	
	public void removeChangeListener(AllianceChangeListener listener)
	{
		m_listeners.remove(listener);
	}
	
	public void copyTeams(Alliance other)
	{
		m_teams = Arrays.copyOf(other.m_teams, 3);
		fireAllianceModified();
	}
	
	private void fireAllianceModified()
	{
		for (AllianceChangeListener listener : m_listeners)
			listener.onAllianceModified(this);
	}
	
	public String toString()
	{
		return "Alliance " + (m_id+1) + ": " + m_teams[0] + " " + m_teams[1] + " " + m_teams[2];
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + m_id;
		result = prime * result + Arrays.hashCode(m_teams);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alliance other = (Alliance) obj;
		if (m_id != other.m_id)
			return false;
		if (!Arrays.equals(m_teams, other.m_teams))
			return false;
		return true;
	}
}
