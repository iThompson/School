import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Simulates a goby fish
 * @author connor.simpson
 */
public class Goby extends Critter
{
    /**
     * Gets all shrimp on the grid

     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Location> actLoc = getGrid().getOccupiedLocations();

        ArrayList<Actor> a = new ArrayList<Actor>();
        for(Location l : actLoc)
            if(getGrid().get(l) instanceof Shrimp)
                a.add(getGrid().get(l));
        return a;
    }

    /**
     * Causes each shrimp to eat or turn if eating is unsafe

     */
    public void processActors(ArrayList<Actor> a)
    {
        for(Actor act : a)
        {
            Location loc = act.getLocation().getAdjacentLocation(act.getDirection());
            if(getGrid().isValid(loc) && !(getGrid().get(loc) instanceof Flower) && !(loc.equals(getLocation())))
                ((Shrimp)act).eat();
            else
            {
                act.setDirection(act.getDirection() + Location.HALF_RIGHT*(int)(Math.random()*6+1));
                ((Shrimp)act).setMoved(false);

            }

        }
    }

    /**
     * Returns a list of possible move location
     * @return a list of possible move locations
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int row = getLocation().getRow();
        int col = getLocation().getCol();
        Location l = null;

        for(int i = -2; i <=2; i++)
            for(int j = -2; j <=2; j++)
            {
                l = new Location(row + i, col + j);
                if(getGrid().isValid(l) && !(getGrid().get(l) instanceof Rock))
                    locs.add(l);
            }
        return locs;   
    }

    /**
     * Selects a move location

     */
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        ArrayList<Location> shrimpLocs = new ArrayList<Location>();
        for(int i = locs.size() - 1; i >= 0; i--)
            if(getGrid().get(locs.get(i)) instanceof Shrimp)
            {
                shrimpLocs.add(locs.get(i));
                locs.remove(i);
            }
        if(shrimpLocs.size() > 0)
            for(int i = shrimpLocs.size() - 1; i >= 0; i--)
            {
                if(((Shrimp)getGrid().get(shrimpLocs.get(i))).getMoved())
                {
                    Location dest = ((Shrimp) getGrid().get(shrimpLocs.get(i))).getPrev();
                    Location mid = getLocation().getAdjacentLocation(getLocation().getDirectionToward(dest));
                    if(getGrid().get(mid) == null && getGrid().isValid(dest))
                        return dest;
                }
            }
        return getLocation();

    }

}