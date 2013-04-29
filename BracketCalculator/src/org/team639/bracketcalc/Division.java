package org.team639.bracketcalc;

public enum Division {
	ARCHIMEDES(0, "A"),
	CURIE(1, "C"),
	GALILEO(2, "G"),
	NEWTON(3, "N");
	
	private int id;
	private String prefix;
	private static Division[] BY_ID = new Division[Division.values().length];
	
	private Division(int id, String prefix)
	{
		this.id = id;
		this.prefix = prefix;
	}
	
	public String getPrefix()
	{
		return this.prefix;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public static Division byId(int id)
	{
		return BY_ID[id];
	}
	
	static
	{
		for (Division division : values())
		{
			BY_ID[division.id] = division; 
		}
	}
}
