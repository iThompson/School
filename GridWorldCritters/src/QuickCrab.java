import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class QuickCrab extends CrabCritter
{
	@Override
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> locs = new ArrayList<Location>();
		Location myLoc = getLocation();
		Grid<Actor> grd = getGrid();
		
		int[] dirs = {Location.LEFT, Location.RIGHT};
		for (int d : dirs)
		{
			Location neighbor = myLoc.getAdjacentLocation(d);
			if (grd.isValid(neighbor) && grd.get(neighbor) == null)
			{
				Location target = neighbor.getAdjacentLocation(d);
				if (grd.isValid(target) && grd.get(target) == null)
					locs.add(target);
			}
		}
		
		return locs;
	}
}
