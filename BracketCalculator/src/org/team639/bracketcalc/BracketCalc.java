package org.team639.bracketcalc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

import org.team639.bracketcalc.parser.BracketParser;

public class BracketCalc implements ActionListener
{

	private JFrame frame;
	
	private JTextField[][] m_allianceInput;
	private MatchPanel[][] m_matches;
	private Alliance[] m_alliances;
	
	private JTextField m_nameInput;
	private JTextField m_accountNameInput;
	private JTextField m_emailInput;
	private JTextField m_teamInput;
	
	private ButtonModel[] m_divModels;
	private ButtonGroup m_divGroup;
	
	private static final String dataFolder = "C:\\Users\\Ian\\AprilAbsurdity";
	
	private Bracket m_curBracket;
	private Bracket m_keyBracket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					BracketCalc window = new BracketCalc();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BracketCalc()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		m_allianceInput = new JTextField[8][3];
		m_matches = new MatchPanel[3][];
		m_matches[0] = new MatchPanel[4];
		m_matches[1] = new MatchPanel[2];
		m_matches[2] = new MatchPanel[1];
		m_alliances = new Alliance[8];
		for (int i = 0; i < 8; i++)
		{
			m_alliances[i] = new Alliance(i + 1);
		}
		m_divModels = new ButtonModel[5];
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 816, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mnOpen = new JMenuItem("Open...");
		mnOpen.setActionCommand("importDialog");
		mnOpen.addActionListener(this);
		mnFile.add(mnOpen);
		
		JMenu mnBracket = new JMenu("Bracket");
		menuBar.add(mnBracket);
		
		ButtonGroup grpBracket = new ButtonGroup();
		
		JRadioButtonMenuItem rdbtnmntmKey = new JRadioButtonMenuItem("Key");
		rdbtnmntmKey.setActionCommand("keyBracket");
		rdbtnmntmKey.addActionListener(this);
		mnBracket.add(rdbtnmntmKey);
		grpBracket.add(rdbtnmntmKey);
		
		mnBracket.addSeparator();
		
		JRadioButtonMenuItem rdbtnmntmUser = new JRadioButtonMenuItem("User...");
		rdbtnmntmUser.setActionCommand("userBracket");
		rdbtnmntmUser.addActionListener(this);
		mnBracket.add(rdbtnmntmUser);
		grpBracket.add(rdbtnmntmUser);
		
		JMenu mnDivision = new JMenu("Division");
		menuBar.add(mnDivision);
		
		m_divGroup = new ButtonGroup();
		JRadioButtonMenuItem rdbtnmntmArchimedes = new JRadioButtonMenuItem("Archimedes");
		rdbtnmntmArchimedes.setActionCommand("divA");
		rdbtnmntmArchimedes.addActionListener(this);
		m_divModels[0] = rdbtnmntmArchimedes.getModel();
		mnDivision.add(rdbtnmntmArchimedes);
		m_divGroup.add(rdbtnmntmArchimedes);
		
		JRadioButtonMenuItem rdbtnmntmCurie = new JRadioButtonMenuItem("Curie");
		rdbtnmntmCurie.setActionCommand("divC");
		rdbtnmntmCurie.addActionListener(this);
		m_divModels[1] = rdbtnmntmCurie.getModel();
		mnDivision.add(rdbtnmntmCurie);
		m_divGroup.add(rdbtnmntmCurie);
		
		JRadioButtonMenuItem rdbtnmntmGalileo = new JRadioButtonMenuItem("Galileo");
		rdbtnmntmGalileo.setActionCommand("divG");
		rdbtnmntmGalileo.addActionListener(this);
		m_divModels[2] = rdbtnmntmGalileo.getModel();
		mnDivision.add(rdbtnmntmGalileo);
		m_divGroup.add(rdbtnmntmGalileo);
		
		JRadioButtonMenuItem rdbtnmntmNewton = new JRadioButtonMenuItem("Newton");
		rdbtnmntmNewton.setActionCommand("divN");
		rdbtnmntmNewton.addActionListener(this);
		m_divModels[3] = rdbtnmntmNewton.getModel();
		mnDivision.add(rdbtnmntmNewton);
		m_divGroup.add(rdbtnmntmNewton);
		
		mnDivision.addSeparator();
		
		JRadioButtonMenuItem rdbtnmntmEinstein = new JRadioButtonMenuItem("Einstein");
		rdbtnmntmEinstein.setActionCommand("Ein");
		rdbtnmntmEinstein.addActionListener(this);
		m_divModels[4] = rdbtnmntmEinstein.getModel();
		mnDivision.add(rdbtnmntmEinstein);
		m_divGroup.add(rdbtnmntmEinstein);
		
		frame.getContentPane().setLayout(new MigLayout("", "[][35.00px][35px][35px][][][][][][][]", "[14px][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00][25.00:25.00:25.00]"));
		
		JLabel lblAlliances = new JLabel("Alliances");
		frame.getContentPane().add(lblAlliances, "cell 1 0 3 1,alignx center,aligny top");
		
		// Build alliance rows
		for (int i = 0; i < 8; i++)
		{
			JLabel label = new JLabel("" + (i + 1));
			frame.getContentPane().add(label, "cell 0 " + (i + 1) + ",alignx trailing");
			
			for (int j = 0; j < 3; j++)
			{
				JTextField team = new JTextField();
				frame.getContentPane().add(team, "cell " + (j + 1) + " " + (i + 1) + ",grow");
				m_allianceInput[i][j] = team;
				AllianceInputListener listener = new AllianceInputListener(m_alliances[i], j);
				team.addFocusListener(listener);
				team.addActionListener(listener);
			}
		}
		
		// Add Bracket info fields
		JLabel lblName = new JLabel("Name");
		frame.getContentPane().add(lblName, "cell 0 10 2 1,alignx trailing");
		m_nameInput = new JTextField();
		frame.getContentPane().add(m_nameInput, "cell 2 10 2 1,grow");
		
		JLabel lblAccount = new JLabel("Account");
		frame.getContentPane().add(lblAccount, "cell 0 11 2 1,alignx trailing");
		m_accountNameInput = new JTextField();
		frame.getContentPane().add(m_accountNameInput, "cell 2 11 2 1,grow");
		
		JLabel lblEmail = new JLabel("Email");
		frame.getContentPane().add(lblEmail, "cell 0 12 2 1,alignx trailing");
		m_emailInput = new JTextField();
		frame.getContentPane().add(m_emailInput, "cell 2 12 2 1,grow");
		
		JLabel lblTeam = new JLabel("Team");
		frame.getContentPane().add(lblTeam, "cell 0 13 2 1,alignx trailing");
		m_teamInput = new JTextField();
		frame.getContentPane().add(m_teamInput, "cell 2 13 2 1,grow");
		
		
		// Grand match creator?
		for (int i = m_matches.length-1; i >= 0; i--)
		{
			for (int j = 0; j < m_matches[i].length; j++)
			{
				MatchPanel panel;
				if (i == 2)
					panel = new MatchPanel("F");
				else
					panel = new MatchPanel((i == 0 ? "QF" : "SF") + (j + 1));
				m_matches[i][j] = panel;
				if (i != 2)
				{
					// Bind results to next match
					panel.setResultPanel(m_matches[i+1][j / 2], j % 2);
				}
				frame.getContentPane().add(panel, "cell " + (5 + 2*i) + " " + (i == 2 ? 7 : (4*(i+1)*j+2*i+1)) + " 1 3,grow");
			}
		}
		
		// Bind Alliances to qualification matches
		m_matches[0][0].setAlliance(0, m_alliances[0]);
		m_matches[0][0].setAlliance(1, m_alliances[7]);
		m_matches[0][1].setAlliance(0, m_alliances[3]);
		m_matches[0][1].setAlliance(1, m_alliances[4]);
		m_matches[0][2].setAlliance(0, m_alliances[1]);
		m_matches[0][2].setAlliance(1, m_alliances[6]);
		m_matches[0][3].setAlliance(0, m_alliances[2]);
		m_matches[0][3].setAlliance(1, m_alliances[5]);
	}
	
	private void refreshAllianceInputs()
	{
		for (int i = 0; i < m_alliances.length; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				m_allianceInput[i][j].setText("" + m_alliances[i].getTeam(j));
			}
		}
	}
	
	public void loadDivision(BracketDivision division)
	{
		// Load alliances
		for (int i = 0; i < 8; i++)
		{
			m_alliances[i].copyTeams(division.getAlliance(i + 1));
		}
		refreshAllianceInputs();
		
		// Load match results
		for (MatchRound round : MatchRound.values())
		{
			for (int i = 0; i < round.getNumMatches(); i++)
			{
				m_matches[round.getId()][i].setResult(division.getResult(round, i));
			}
		}
		
		divisionMode();
	}
	
	public void loadEinstein(BracketEinstein einstein)
	{
		for (Division div : Division.values())
		{
			m_alliances[div.getId()].copyTeams(einstein.getAlliance(div));
		}
		
		// Bind SF panels to division winners
		m_matches[1][0].setAlliance(0, m_alliances[0]);
		m_matches[1][0].setAlliance(1, m_alliances[1]);
		m_matches[1][1].setAlliance(0, m_alliances[2]);
		m_matches[1][1].setAlliance(1, m_alliances[3]);
		
		for (int i = 0; i < MatchRound.SEMI.getNumMatches(); i++)
		{
			m_matches[1][i].setResult(einstein.getResult(MatchRound.SEMI, i));
		}
		
		m_matches[2][0].setResult(einstein.getResult(MatchRound.FINAL, 0));
		
		einsteinMode();
	}
	
	private void importBracketDialog()
	{
		final JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(dataFolder + "\\Dump"));
		fc.setFileFilter(new FileNameExtensionFilter("XML Form Dump", "xml"));
		
		int returnVal = fc.showOpenDialog(frame);
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File bracketFile = fc.getSelectedFile();
			BracketParser parser;
			try
			{
				parser = new BracketParser(new FileInputStream(bracketFile));
			}
			catch (FileNotFoundException e)
			{
				System.out.println("File mysteriously disappeared");
				return;
			}
			Bracket bracket = parser.parse();
			if (bracket != null && bracket.hasDivision(Division.ARCHIMEDES))
			{
				loadDivision(bracket.getDivisionBracket(Division.ARCHIMEDES));
			}
		}
	}
	
	private void einsteinMode()
	{
		for (JTextField[] row : m_allianceInput)
		{
			for (JTextField field : row)
			{
				field.setText("");
				field.setEnabled(false);
			}
		}
		
		for (MatchPanel panel : m_matches[0])
		{
			panel.setEnabled(false);
		}
	}
	
	private void divisionMode()
	{
		for (JTextField[] row : m_allianceInput)
		{
			for (JTextField field : row)
			{
				field.setEnabled(true);
				field.requestFocus(); // Triggers data to update
			}
		}
		
		for (MatchPanel panel : m_matches[0])
		{
			panel.setEnabled(true);
		}
	}
	
	public void selectEinstein()
	{
		m_divGroup.setSelected(m_divModels[4], true);
		loadEinstein(m_curBracket.getEinsteinBracket());
		
		einsteinMode();
	}
	
	public void selectDivision(Division div)
	{
		m_divGroup.setSelected(m_divModels[div.getId()], true);
		loadDivision(m_curBracket.getDivisionBracket(div));
		
		divisionMode();
	}
	
	public void setBracket(Bracket bracket)
	{
		m_curBracket = bracket;
		
		for (Division div : Division.values())
		{
			if (bracket.hasDivision(div))
			{
				selectDivision(div);
				return;
			}
		}
		
		selectDivision(Division.ARCHIMEDES);
	}

	@Override
	public void actionPerformed(ActionEvent a)
	{
		String command = a.getActionCommand();
		if (command.equals("importDialog"))
		{
			importBracketDialog();
		}
		else if (command.equals("divA"))
		{
			selectDivision(Division.ARCHIMEDES);
		}
		else if (command.equals("divC"))
		{
			selectDivision(Division.CURIE);
		}
		else if (command.equals("divG"))
		{
			selectDivision(Division.GALILEO);
		}
		else if (command.equals("divN"))
		{
			selectDivision(Division.NEWTON);
		}
		else if (command.equals("Ein"))
		{
			selectEinstein();
		}
	}
}
