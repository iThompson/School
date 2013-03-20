import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Alien extends Critter
{
    /**
     * Returns a list of all humans in a 5x5 square centered on the alien
     * @return a list of all humans in a 5x5 square centered on the alien
     */
    public ArrayList<Actor> getActors()
    {
        int row = getLocation().getRow();
        int col = getLocation().getCol();
        ArrayList<Actor> a = new ArrayList<Actor>();
        for(int i = -2; i <=2; i++)
            for(int j = -2; j <= 2; j++)
            {
                Location loc = new Location(row + i, col + j);
                if(getGrid().isValid(loc) && getGrid().get(loc) instanceof Human) //NEED TO MAKE HUMAN
                    a.add(getGrid().get(loc));
            }
        return a;
    }

    /**
     * Turns the actors to face the alien and moves them 1 space closer if they are > 1 space away
     */
    public void processActors(ArrayList<Actor> a)
    {
        for(int i = a.size() - 1; i >= 0; i--)//Draws in nearby humans
        {
            a.get(i).setDirection(a.get(i).getLocation().getDirectionToward(getLocation()));
            if(distanceTo(a.get(i).getLocation()) > 1)
                a.get(i).moveTo(a.get(i).getLocation().getAdjacentLocation(a.get(i).getDirection()));
        }
        for(int i = 0; i <8; i++) //Turns around eating humans around it
        {
            setDirection(getDirection() + 45);
            Location l = getLocation().getAdjacentLocation(getDirection());
            if(getGrid().isValid(l) && getGrid().get(l) instanceof Human)
                getGrid().get(l).removeSelfFromGrid();
        }
    }

    /**
     * Returns a list of possible move locations
     * @return a list of possible move locations
     */
    public ArrayList<Location> getMoveLocations()
    {
        int row = getLocation().getRow();
        int col = getLocation().getCol();
        ArrayList<Actor> a = new ArrayList<Actor>();
        for(int i = -2; i <=2; i++)
            for(int j = -2; j <= 2; j++)
            {
                Location loc = new Location(row + i, col + j);
                if(getGrid().isValid(loc) && getGrid().get(loc) instanceof Human) //NEED TO MAKE HUMAN
                    a.add(getGrid().get(loc));
            }
        ArrayList<Location> locs = new ArrayList<Location>();
        if(a.size() > 0)
        {
            int min = distanceTo(a.get(0).getLocation()); //Finds the minimum distance
            for(int i = a.size() - 1; i > 0; i--)
            {
                if(distanceTo(a.get(0).getLocation()) < min)
                    min = distanceTo(a.get(0).getLocation());
            }
            for(Actor act : a) //Adds locations of actors at min
                if(distanceTo(act.getLocation()) == min)
                    locs.add(act.getLocation());
            int minDist = distanceTo(locs.get(0)); //Find minimum distance to an adjacent location of a human
            for(Location l :locs)
            {
                for(int i = 0; i < 8; i++)
                {
                    if(distanceTo(l.getAdjacentLocation(45 * i)) < minDist)
                        minDist = distanceTo(l.getAdjacentLocation(45 * i));
                }
            }
            ArrayList<Location> retLocs = new ArrayList<Location>();
            for(Location l :locs) //Adds the adjacent locations at the lowest distances to the final array
            {
                for(int i = 0; i < 8; i++)
                {
                    if(distanceTo(l.getAdjacentLocation(45 * i)) == minDist)
                        retLocs.add(l.getAdjacentLocation(45 * i));
                }
            }
            return retLocs;
        }
        locs.add(getLocation());
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
   
    /**
     * Returns a random location from the list of locations
     * @param locs the list of locations
     * @return the location to move to
     */
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        return locs.get((int)(Math.random() * locs.size()));

    }

}