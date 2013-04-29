package org.team639.bracketcalc;

import java.util.HashMap;
import java.util.Map;

public class Bracket {
	private String mName;
	private String mAccountName;
	private String mEmail;
	private int mTeam;
	
	private boolean mLFBonus;
	
	private Map<Division, BracketDivision> mDivisions;
	
	private BracketEinstein mEinstein;
	
	public Bracket(String name, String accountName, String email, int team)
	{
		mName = name;
		mAccountName = accountName;
		mEmail = email;
		mTeam = team;
		mLFBonus = false;
		
		mDivisions = new HashMap<Division, BracketDivision>();
		
		mEinstein = null;
	}
	
	public void setDivisionBracket(Division div, BracketDivision bracket)
	{
		mDivisions.put(div, bracket);
	}
	
	public BracketDivision getDivisionBracket(Division div)
	{
		return mDivisions.get(div);
	}
	
	public void setEinsteinBracket(BracketEinstein bracket)
	{
		mEinstein = bracket;
	}
	
	public BracketEinstein getEinsteinBracket()
	{
		return mEinstein;
	}
	
	public void setLFBounus(boolean bonus)
	{
		mLFBonus = true;
	}
	
	public boolean hasLFBonus()
	{
		return mLFBonus;
	}
	
	public String getName()
	{
		return mName;
	}
	
	public String getAccountName()
	{
		return mAccountName;
	}
	
	public String getEmail()
	{
		return mEmail;
	}
	
	public int getTeam()
	{
		return mTeam;
	}
	
	public boolean hasDivision(Division div)
	{
		return mDivisions.containsKey(div);
	}
}
