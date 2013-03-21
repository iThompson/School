import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Alien extends Critter
{
	/**
	 * Returns a list of all humans in a 5x5 square centered on the alien
	 * @return a list of all humans in a 5x5 square centered on the alien
	 */
	@Override
	public ArrayList<Actor> getActors()
	{
		int row = getLocation().getRow();
		int col = getLocation().getCol();
		ArrayList<Actor> a = new ArrayList<Actor>();
		for(int i = -2; i <=2; i++)
			for(int j = -2; j <= 2; j++)
			{
				Location loc = new Location(row + i, col + j);
				if(getGrid().isValid(loc) && getGrid().get(loc) instanceof Human)
					a.add(getGrid().get(loc));
			}
		return a;
	}

	/**
	 * Turns the actors to face the alien and moves them 1 space closer if they are > 1 space away
	 */
	@Override
	public void processActors(ArrayList<Actor> a)
	{
		for (Actor act : a)
		{
			Location otherLoc = act.getLocation();
			if (isAdjacent(otherLoc))
			{
				act.removeSelfFromGrid();
			}
			else
			{
				Human human = (Human) act;
				Location myLoc = getLocation();
				int directionToHuman = myLoc.getDirectionToward(otherLoc);
				act.moveTo(myLoc.getAdjacentLocation(directionToHuman));
				directionToHuman = myLoc.getDirectionToward(human.getLocation()); // Direction might change when moving the human
				act.setDirection(directionToHuman + Location.HALF_CIRCLE);
				human.hypnotize();
			}
		}
	}

	/**
	 * Returns a list of possible move locations
	 * @return a list of possible move locations
	 */
	@Override
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> locs = new ArrayList<Location>();
		Location myLoc = getLocation();
		Grid<Actor> grd = getGrid();
		
		// If we already are drawing one in, don't move
		if (hasNearHuman())
			return locs; // Always empty list at this point
		
		// Find all the humans on the grid
		ArrayList<Human> humans = new ArrayList<Human>();
		for (Location loc : grd.getOccupiedLocations())
		{
			Actor act = grd.get(loc);
			if (act instanceof Human)
				humans.add((Human) act);
		}
		
		// Determine which human(s) is/are closest
		ArrayList<Location> targetLocs = new ArrayList<Location>();
		int minDist = Integer.MAX_VALUE;
		for (Human human : humans)
		{
			Location loc = human.getLocation();
			int distance = distanceTo(loc); // Creates "rings" around Alien, so that more than one target can be found
			if (distance < minDist)
			{
				targetLocs.clear();
				targetLocs.add(loc);
				minDist = distance;
			}
			else if (distance == minDist)
			{
				targetLocs.add(loc);
			}
		}
		
		// Build list of adjacent tiles to move to
		for (Location loc : targetLocs)
		{
			int direction = myLoc.getDirectionToward(loc);
			locs.add(myLoc.getAdjacentLocation(direction)); // Aliens stop for nothing :D
		}
		
		return locs;
	}

	/**
	 * Returns the rounded distance to any location from this
	 * @param loc the location to which the distance is needed
	 * @return the distance to loc
	 */
	private int distanceTo(Location loc)
	{
		int rowChange = loc.getRow() - getLocation().getRow();
		int colChange = loc.getCol() - getLocation().getCol();
		return (int)(Math.sqrt(rowChange * rowChange + colChange * colChange) + .5);
	}
	
	@Override
	public void makeMove(Location loc)
	{
		if (loc != null && !getLocation().equals(loc))
			setDirection(getLocation().getDirectionToward(loc));
		
		super.makeMove(loc);
	}

	private boolean isAdjacent(Location loc)
	{
		Location myLoc = getLocation();
		if (myLoc.equals(loc))
			return false;
		int dx = Math.abs(myLoc.getCol() - loc.getCol());
		int dy = Math.abs(myLoc.getRow() - loc.getRow());
		if (dx <= 1 && dy <= 1)
			return true;
		else
			return false;
	}
	
	private boolean hasNearHuman()
	{
		Location myLoc = getLocation();
		Grid<Actor> grd = getGrid();
		for (int i = -2; i <= 2; i++)
		{
			for (int j = -2; j <= 2; j++)
			{
				Location loc = new Location(myLoc.getRow() + i, myLoc.getCol() + j);
				if (getGrid().isValid(loc))
				{
					Actor neighbor = grd.get(loc);
					if (neighbor != null && neighbor instanceof Human)
						return true;
				}
			}
		}
		return false;
	}
}