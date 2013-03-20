import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class Catfish extends Critter
{
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		for (Actor a : actors)
      {
			if (a instanceof Mussel)
			{
				Location curLoc = getLocation();
				Location otherLoc = a.getLocation();
				if (curLoc.getAdjacentLocation(getDirection()).equals(otherLoc)
						|| curLoc.getAdjacentLocation(getDirection() + Location.HALF_CIRCLE).equals(otherLoc))
					a.removeSelfFromGrid();
			}
			else if (!(a instanceof Rock) && !(a instanceof Critter))
              a.removeSelfFromGrid();
      }
	}
}
