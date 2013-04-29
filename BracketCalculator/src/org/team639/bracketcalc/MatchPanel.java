package org.team639.bracketcalc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class MatchPanel extends JPanel implements ActionListener, AllianceChangeListener
{
	private JLabel[][] m_allianceText;
	private ButtonGroup m_lengthGroup;
	private ButtonModel m_twoGameModel;
	private ButtonModel m_threeGameModel;
	private ButtonGroup m_winGroup;
	private ButtonModel m_redWinModel;
	private ButtonModel m_blueWinModel;

	private Alliance[] m_alliances;

	private String m_matchName;

	private MatchPanel m_resultPanel;
	private int m_resultSlot;
	private boolean m_redWin;
	private boolean m_twoGame;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void drawAlliance(int slot, Alliance a)
	{
		for (int i = 0; i < 3; i++)
		{
			m_allianceText[slot][i].setText("" + a.getTeam(i));
		}
	}

	public void redraw()
	{
		if (m_alliances[0].getId() < m_alliances[1].getId())
		{
			drawAlliance(0, m_alliances[0]);
			drawAlliance(1, m_alliances[1]);
		}
		else
		{
			drawAlliance(0, m_alliances[1]);
			drawAlliance(1, m_alliances[0]);
		}
	}

	public void setAlliance(int slot, Alliance a)
	{
		if (slot < 0 || slot > 1)
			throw new IllegalArgumentException("Invalid alliance slot");

		m_alliances[slot].removeChangeListener(this);
		m_alliances[slot] = a;
		a.addChangeListener(this);
		redraw();
		pushResult();
	}

	public void setResultPanel(MatchPanel resultPanel, int resultSlot)
	{
		m_resultPanel = resultPanel;
		m_resultSlot = resultSlot;
	}

	/**
	 * Create the panel.
	 */
	public MatchPanel(String matchName)
	{
		m_resultPanel = null;
		m_alliances = new Alliance[2];
		m_allianceText = new JLabel[2][3];
		m_matchName = matchName;
		m_redWin = true;
		m_twoGame = true;

		for (int i = 0; i < m_alliances.length; i++)
		{
			m_alliances[i] = new Alliance(-1);
		}

		setLayout(new MigLayout("", "[35.00px][35.00px][35.00px][50.00px]", "[20.00][:20.00:20.00][:20.00:20.00]"));

		// Build Red alliance text
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				JLabel label = new JLabel("9999");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBackground(i == 0 ? Color.RED : Color.BLUE);
				label.setForeground(i == 0 ? Color.BLACK : Color.WHITE);
				label.setOpaque(true);
				m_allianceText[i][j] = label;
				add(label, "cell " + j + " " + 2*i + ",grow");
			}
		}

		//		JLabel label = new JLabel("9999");
		//		label.setHorizontalAlignment(SwingConstants.CENTER);
		//		label.setBackground(Color.RED);
		//		label.setOpaque(true);
		//		add(label, "cell 0 0,grow");
		//		
		//		JLabel label_1 = new JLabel("9999");
		//		label_1.setBackground(Color.RED);
		//		add(label_1, "cell 1 0,alignx center");
		//		
		//		JLabel label_2 = new JLabel("9999");
		//		label_2.setBackground(Color.RED);
		//		add(label_2, "cell 2 0,alignx center");

		JLabel lblQf = new JLabel(m_matchName);
		add(lblQf, "cell 0 1");

		m_lengthGroup = new ButtonGroup();
		JRadioButton twoGame = new JRadioButton("2");
		twoGame.setActionCommand("twoGame");
		twoGame.addActionListener(this);
		m_lengthGroup.add(twoGame);
		twoGame.setSelected(true);
		m_twoGameModel = twoGame.getModel();
		add(twoGame, "cell 1 1");

		JRadioButton threeGame = new JRadioButton("3");
		threeGame.setActionCommand("threeGame");
		threeGame.addActionListener(this);
		m_lengthGroup.add(threeGame);
		m_threeGameModel = threeGame.getModel();
		add(threeGame, "cell 2 1");
		//		
		//		JLabel label_3 = new JLabel("9999");
		//		add(label_3, "cell 0 2,alignx center");
		//		
		//		JLabel label_4 = new JLabel("9999");
		//		add(label_4, "cell 1 2,alignx center");
		//		
		//		JLabel label_5 = new JLabel("9999");
		//		add(label_5, "cell 2 2,alignx center");

		m_winGroup = new ButtonGroup();
		JRadioButton redWin = new JRadioButton("Win");
		redWin.setActionCommand("redWin");
		redWin.addActionListener(this);
		m_winGroup.add(redWin);
		redWin.setSelected(true);
		m_redWinModel = redWin.getModel();
		add(redWin, "cell 3 0");

		JRadioButton blueWin = new JRadioButton("Win");
		blueWin.setActionCommand("blueWin");
		blueWin.addActionListener(this);
		m_winGroup.add(blueWin);
		m_blueWinModel = blueWin.getModel();
		add(blueWin, "cell 3 2");

		redraw();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equals("redWin"))
		{
			m_redWin = true;
			pushResult();
		}
		else if (command.equals("blueWin"))
		{
			m_redWin = false;
			pushResult();
		}
		else if (command.equals("twoGame"))
		{
			m_twoGame = true;
		}
		else if (command.equals("threeGame"))
		{
			m_twoGame = false;
		}
	}

	@Override
	public void onAllianceModified(Alliance a)
	{
		redraw();
	}

	private void pushResult()
	{
		if (m_resultPanel != null)
		{
			m_resultPanel.setAlliance(m_resultSlot, getWinner());
		}
	}
	
	public Alliance getWinner()
	{
		if ((m_alliances[0].getId() < m_alliances[1].getId()) ^ m_redWin)
		{
			return m_alliances[1];
		}
		else
		{
			return m_alliances[0];
		}
	}
	
	public MatchResult getResult()
	{
		return new MatchResult(m_redWin, m_twoGame, getWinner());
	}
	
	public void setResult(MatchResult result)
	{
		setRedWin(result.wasRedWin());
		setTwoGame(result.wasTwoGame());
		pushResult();
	}
	
	public void setRedWin(boolean redWin)
	{
		m_redWin = redWin;
		m_winGroup.setSelected(redWin ? m_redWinModel : m_blueWinModel, true);
	}
	
	public void setTwoGame(boolean twoGame)
	{
		m_twoGame = twoGame;
		m_winGroup.setSelected(twoGame ? m_twoGameModel : m_threeGameModel, true);
	}

}
