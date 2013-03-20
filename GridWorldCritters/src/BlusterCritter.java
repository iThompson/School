import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class BlusterCritter extends Critter
{
	private int count;
	
	public BlusterCritter(int c)
	{
		count = c;
	}
	
	@Override
	public ArrayList<Actor> getActors()
	{
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Grid<Actor> grd = getGrid();
		Location myLoc = getLocation();
		for (int row = myLoc.getRow() - 2; row <= myLoc.getRow() + 2; row++)
		{
			for (int col = myLoc.getCol() - 2; col <= myLoc.getCol() + 2; col++)
			{
				Location loc = new Location(row, col);
				if (grd.isValid(loc) && !loc.equals(myLoc))
				{
					Actor act = grd.get(loc);
					if (act != null && act instanceof Critter)
						actors.add(act);
				}
					
			}
		}
		
		return actors;
	}
	
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		if (actors.size() < count)
		{
			setColor(getColor().brighter());
		}
		else
		{
			setColor(getColor().darker());
		}
	}
}
