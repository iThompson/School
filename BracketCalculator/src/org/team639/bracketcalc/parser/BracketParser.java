package org.team639.bracketcalc.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.ParsingException;

import org.team639.bracketcalc.Alliance;
import org.team639.bracketcalc.Bracket;
import org.team639.bracketcalc.BracketDivision;
import org.team639.bracketcalc.BracketEinstein;
import org.team639.bracketcalc.Division;
import org.team639.bracketcalc.Match;
import org.team639.bracketcalc.MatchResult;
import org.team639.bracketcalc.MatchRound;

public class BracketParser {
	private InputStream mSource;

	public BracketParser(InputStream source)
	{
		mSource = source;
	}

	public Bracket parse()
	{
		Document doc;

		try
		{
			Builder builder = new Builder();
			doc = builder.build(mSource);
		}
		catch (ParsingException | IOException e)
		{
			System.out.println("Failed parsing bracket");
			e.printStackTrace();
			return null;
		}
		
		Element root = doc.getRootElement();
		String name;
		String accountName;
		String email;
		int teamNumber;
		
		try
		{
			name = root.getFirstChildElement("Name").getValue();
		}
		catch (NullPointerException e)
		{
			name = "";
		}
		try
		{
			accountName = root.getFirstChildElement("CDAccount").getValue();
		}
		catch (NullPointerException e)
		{
			accountName = "";
		}
		try
		{
			email = root.getFirstChildElement("Email").getValue();
		}
		catch (NullPointerException e)
		{
			email = "";
		}
		try
		{
			teamNumber = Integer.parseInt(root.getFirstChildElement("Name").getValue());
		}
		catch (NullPointerException | NumberFormatException e)
		{
			teamNumber = -1;
		}
		
		Bracket bracket = new Bracket(name, accountName, email, teamNumber);
		
		boolean hasAllDivisions = true;
		for (Division div : Division.values())
		{
			try
			{
				bracket.setDivisionBracket(div, parseDivision(div, root));
			}
			catch (BracketParseException e)
			{
				System.out.println("Ignoring " + div + " for " + name + " (CD: " + accountName + "): " + e.getMessage());
				hasAllDivisions = false;
			}
		}
		
		if (hasAllDivisions)
		{
			BracketEinstein einstein = new BracketEinstein();
			for (Division div : Division.values())
			{
				Alliance a = new Alliance(div.getId() + 1);
				a.copyTeams(bracket.getDivisionBracket(div).getWinner());
				einstein.setAlliance(div, a);
			}
			
			try
			{
				parseEinstein(einstein, root);
				bracket.setEinsteinBracket(einstein);
			}
			catch (BracketParseException e)
			{
				System.out.println("Ignoring Einstein for " + name + " (CD: " + accountName + "): " + e.getMessage());
			}
		}
		
		return bracket;

	}

	public static void main(String[] args)
	{
		BracketParser parser;
		try
		{
			parser = new BracketParser(new FileInputStream("C:\\Users\\Ian\\Downloads\\AprilAbsurdity\\Dump\\BleakRNS.xml"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Failed to open bracket file");
			return;
		}
		parser.parse();
		
		/*
		Alliance[] alliances = new Alliance[8];
		for (int i = 0; i < 8; i++)
		{
			alliances[i] = new Alliance(i);
		}

		int[] aMap = {0, 4, 6, 2, 3, 7, 5, 1};

		Document doc;

		try
		{
			Builder builder = new Builder();
			doc = builder.build(new FileInputStream("C:\\Users\\Programmer\\Desktop\\AprilAbsurdity.xml"));
		}
		catch (IOException e)
		{
			System.out.println("IOException!");
			return;
		} catch (ValidityException e) {
			System.out.println("ValidityException!");
			e.printStackTrace();
			return;
		} catch (ParsingException e) {
			System.out.println("ParsingException!");
			e.printStackTrace();
			return;
		}

		Element root = doc.getRootElement();
		for (int i = 0; i < 24; i++)
		{
			Element field = root.getFirstChildElement("A" + (i + 1));
			if (field == null)
			{
				System.out.println("Failed to find element A" + (i + 1));
				return;
			}
			try
			{
				int id = aMap[i / 3];
				alliances[id].setTeam(i % 3, Integer.parseInt(field.getValue()));
			}
			catch (NumberFormatException e)
			{
				System.out.println("Bad team field at A" + (i+1));
				return;
			}
		}

		for (Alliance a : alliances)
		{
			System.out.println(a);
		}

		// Identify semi alliances
		for (int i = 0; i < 4; i++)
		{
			int fieldId = i*3 + 25;
			Element mainField = root.getFirstChildElement("A" + fieldId);
			Element altField = root.getFirstChildElement("A" + (fieldId+1));
			if (mainField == null || altField == null)
			{
				System.out.println("Empty bracket at semi " + i);
				return;
			}
			int main = readTeam(mainField);
			int alt = readTeam(altField);
			int alliance = identifyAlliance(main, alt, alliances);
			if (alliance == -1)
			{
				System.out.println("Failed to identify semi alliance " + (i+1));
				return;
			}
			System.out.println("Semi alliance " + (i+1) + ": " + (alliance+1));
		}
		*/
	}

	private static int readTeam(Element el)
	{
		int team;

		try
		{
			team = Integer.parseInt(el.getValue());
		}
		catch (NumberFormatException e)
		{
			return -1;
		}

		if (team < 1)
			return -1;

		return team;
	}

	private static int matchTeam(int team, Alliance[] alliances)
	{
		int id = -1;

		for (int i = 0; i < alliances.length; i++)
		{
			if (alliances[i].containsTeam(team))
			{
				id = i;
				break;
			}
		}

		return id;
	}

	private static int identifyAlliance(int main, int alt, Alliance[] alliances)
	{
		int id = matchTeam(main, alliances);

		if (id != -1)
			return id;

		// Might have taken a backup bot. Can't have more than one
		id = matchTeam(alt, alliances);
		return id;
	}

	private BracketDivision parseDivision(Division div, Element root) throws BracketParseException
	{
		BracketDivision division = new BracketDivision(div);
		int[] aMap = {1, 8, 4, 5, 2, 7, 3, 6};
		Match[] qfMatch = new Match[4];
		for (int i = 0; i < qfMatch.length; i++)
		{
			qfMatch[i] = new Match(MatchRound.QUARTER, i+1);
		}

		// Create empty alliances
		for (int i = 0; i < 8; i++)
		{
			Alliance a = new Alliance(i + 1);
			division.putAlliance(a);
		}
		
		// Bind alliances to matches
		for (int i = 0; i < 8; i++)
		{
			int aId = aMap[i];
			Match match = qfMatch[i / 2];
			Alliance a = division.getAlliance(aId);
			if (aId < 5)
			{
				match.setRedAlliance(a);
			}
			else
			{
				match.setBlueAlliance(a);
			}
		}

		// Build alliances
		for (int i = 0; i < 24; i++)
		{
			String fieldName = div.getPrefix() + (i+1);
			Element field = root.getFirstChildElement(fieldName);
			if (field == null)
				throw new BracketParseException("Missing field " + fieldName);

			int team = readTeam(field);
			if (team == -1)
				throw new BracketParseException("Invalid team at " + fieldName);

			division.getAlliance(aMap[i / 3]).setTeam(i % 3, team);
		}

		Match[] sfMatch = new Match[2];
		for (int i = 0; i < sfMatch.length; i++)
		{
			sfMatch[i] = new Match(MatchRound.SEMI, i+1);
		}
		// Generate QF results from SF alliances
		for (int i = 0; i < 4; i++)
		{
			MatchResult result = getResult(qfMatch[i], i*3+25, div.getId()*7+i+1, division, root);
			division.setResult(MatchRound.QUARTER, i, result);
			qfMatch[i].setResult(result);
			Match match = sfMatch[i / 2];
			if (i % 2 == 0)
			{
				match.setRedAlliance(result.getWinner());
			}
			else
			{
				match.setBlueAlliance(result.getWinner());
			}
		}

		Match fMatch = new Match(MatchRound.FINAL, 1);
		// Repeat for SF results
		for (int i = 0; i < 2; i++)
		{
			MatchResult result = getResult(sfMatch[i], i*3+37, div.getId()*7+i+5, division, root);
			division.setResult(MatchRound.SEMI, i, result);
			sfMatch[i].setResult(result);
			if (i % 2 == 0)
			{
				fMatch.setRedAlliance(result.getWinner());
			}
			else
			{
				fMatch.setBlueAlliance(result.getWinner());
			}
		}

		// And finally the final winner
		MatchResult result = getResult(fMatch, 43, div.getId()*7+7, division, root);
		division.setResult(MatchRound.FINAL, 0, result);
		fMatch.setResult(result);
		division.setWinner(result.getWinner());

		return division;
	}
	
	private void parseEinstein(BracketEinstein einstein, Element root) throws BracketParseException
	{
		Match[] sfMatches = new Match[2];
		sfMatches[0] = new Match(MatchRound.SEMI, 1);
		sfMatches[1] = new Match(MatchRound.SEMI, 2);
		sfMatches[0].setRedAlliance(einstein.getAlliance(Division.ARCHIMEDES));
		sfMatches[0].setBlueAlliance(einstein.getAlliance(Division.CURIE));
		sfMatches[1].setRedAlliance(einstein.getAlliance(Division.GALILEO));
		sfMatches[1].setBlueAlliance(einstein.getAlliance(Division.NEWTON));
		Match fMatch = new Match(MatchRound.FINAL, 1);
		
		for (int i = 0; i < 2; i++)
		{
			MatchResult result = getEinsteinResult(sfMatches[i], i*3+13, 29+i, einstein, root);
			einstein.setResult(MatchRound.SEMI, i, result);
			sfMatches[i].setResult(result);
			if (i % 2 == 0)
			{
				fMatch.setRedAlliance(result.getWinner());
			}
			else
			{
				fMatch.setBlueAlliance(result.getWinner());
			}
		}

		MatchResult result = getEinsteinResult(fMatch, 19, 31, einstein, root);
		einstein.setResult(MatchRound.FINAL, 0, result);
		fMatch.setResult(result);
		einstein.setWinner(result.getWinner());
	}
	
	private MatchResult getEinsteinResult(Match match, int mainId, int lengthId, BracketEinstein einstein, Element root) throws BracketParseException
	{
		Element mainField = root.getFirstChildElement("E" + mainId);
		Element altField = root.getFirstChildElement("E" + (mainId+1));
		if (mainField == null || altField == null)
			throw new BracketParseException("Missing field E" + mainId);

		int main = readTeam(mainField);
		int alt = readTeam(altField);
		Alliance a = einstein.identifyAlliance(main, alt);
		if (a == null)
			throw new BracketParseException("Failed to identify " + match.getRound().getPrefix() + " alliance at " + mainId);
		if (!match.hasAlliance(a))
			throw new BracketParseException("Invalid " + match.getRound().getPrefix() + " alliance at " + mainId);

		boolean redWin = match.getRedAlliance().equals(a);
		String lengthName = "M" + lengthId;
		Element lengthField = root.getFirstChildElement(lengthName);
		if (lengthField == null)
			throw new BracketParseException("Missing field " + lengthName);

		boolean twoGame;
		if (lengthField.getValue().equals("2"))
			twoGame = true;
		else if (lengthField.getValue().equals("3"))
			twoGame = false;
		else
			throw new BracketParseException("Invalid match length in " + lengthName);

		return new MatchResult(redWin, twoGame, a);
	}

	private MatchResult getResult(Match match, int mainId, int lengthId, BracketDivision div, Element root) throws BracketParseException
	{
		Division divId = div.getDivision();
		Element mainField = root.getFirstChildElement(divId.getPrefix() + mainId);
		Element altField = root.getFirstChildElement(divId.getPrefix() + (mainId+1));
		if (mainField == null || altField == null)
			throw new BracketParseException("Missing field " + divId.getPrefix() + mainId);

		int main = readTeam(mainField);
		int alt = readTeam(altField);
		Alliance a = div.identifyAlliance(main, alt);
		if (a == null)
			throw new BracketParseException("Failed to identify " + match.getRound().getPrefix() + " alliance at " + mainId);
		if (!match.hasAlliance(a))
			throw new BracketParseException("Invalid " + match.getRound().getPrefix() + " alliance at " + mainId);

		boolean redWin = match.getRedAlliance().equals(a);
		String lengthName = "M" + lengthId;
		Element lengthField = root.getFirstChildElement(lengthName);
		if (lengthField == null)
			throw new BracketParseException("Missing field " + lengthName);

		boolean twoGame;
		if (lengthField.getValue().equals("2"))
			twoGame = true;
		else if (lengthField.getValue().equals("3"))
			twoGame = false;
		else
			throw new BracketParseException("Invalid match length in " + lengthName);

		return new MatchResult(redWin, twoGame, a);
	}
}
