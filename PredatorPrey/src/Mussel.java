import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Simulates a zebra mussel
 * @author connor.simpson
 * @version 3/19/13
 */
public class Mussel extends Actor
{
    /**
     * Causes the mussel to create offspring if few enough mussels surround it
     */
    public void act()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for(int i = 0; i < 8; i++) //Adds any empty adjacent locations to locs
        {
            Location l = getLocation().getAdjacentLocation(Location.HALF_RIGHT * i);
            if(getGrid().isValid(l) && getGrid().get(l) == null)
                locs.add(l);
        }
        if(locs.size() > 4)
        {
            Mussel m = new Mussel();
            m.putSelfInGrid(getGrid(), locs.get((int)(locs.size() * Math.random())));
        }
    }
}