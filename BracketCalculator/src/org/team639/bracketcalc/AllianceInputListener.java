package org.team639.bracketcalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class AllianceInputListener implements ActionListener, FocusListener
{
	private Alliance m_alliance;
	private int m_position;
	
	public AllianceInputListener(Alliance a, int position)
	{
		m_alliance = a;
		m_position = position;
	}

	@Override
	public void focusGained(FocusEvent e)
	{
	}

	@Override
	public void focusLost(FocusEvent e)
	{
		pushTeam((JTextField) e.getSource());
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		pushTeam((JTextField) e.getSource());
	}
	
	private void pushTeam(JTextField input)
	{
		try
		{
			int team = Integer.parseInt(input.getText());
			m_alliance.setTeam(m_position, team);
		}
		catch (NumberFormatException e)
		{
			int team = m_alliance.getTeam(m_position);
			if (team != 0)
				input.setText("" + m_alliance.getTeam(m_position));
			else
				input.setText("");
		}
	}

}
