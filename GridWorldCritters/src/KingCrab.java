import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class KingCrab extends CrabCritter
{
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		Grid<Actor> grd = getGrid();
		for (Actor act : actors)
		{
			ArrayList<Location> moves = new ArrayList<Location>();
			for (int d = Location.NORTH; d < Location.FULL_CIRCLE; d += Location.HALF_RIGHT)
			{
				Location move = act.getLocation().getAdjacentLocation(d);
				if (grd.isValid(move) && !isAdjacent(move))
				{
					if (grd.get(move) == null)
						moves.add(move);
				}
			}
			
			if (moves.size() == 0)
			{
				act.removeSelfFromGrid();
			}
			else
			{
				act.moveTo(moves.get((int)(Math.random() * moves.size())));
			}
		}
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
}
