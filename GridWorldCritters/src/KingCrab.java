import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class KingCrab extends CrabCritter
{
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		Location myLoc = getLocation();
		Grid<Actor> grd = getGrid();
		for (Actor act : actors)
		{
			Location otherLoc = act.getLocation();
			int direction = myLoc.getDirectionToward(otherLoc);
			Location target = otherLoc.getAdjacentLocation(direction);
			if (grd.isValid(target))
			{
				act.moveTo(target);
			}
			else
			{
				act.removeSelfFromGrid();
			}
		}
	}
}
