import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * Simulates a shrimp
 * @author connor.simpson
 */
public class Shrimp extends Actor
{
    private boolean moved;
    private Location prev;
    /**
     * Creates a shrimp
     * Sets its facing to a random multiple of 45¼ and no previous location
     */
    public Shrimp()
    {
        super();
        setColor(Color.PINK);
        setDirection((int)(Math.random()*8)*45);
        prev = null;
        moved = false;
    }
   
    /**
     * Removes rocks around the shrimp and kills the shrimp if it eats a flower
     */
    public void act()
    {
        //Does nothing
    }
   
    /**
     * Causes the shrimp to eat rocks and die if it eats a flower
     * @return the location of the food
     */
    public Location eat()
    {
        Location foodLoc = getLocation().getAdjacentLocation(getDirection());
        Actor food = getGrid().get(foodLoc);
            if(getGrid().isValid(foodLoc))
            {
                prev = getLocation();
                moved = true;
                moveTo(foodLoc);
            }
            else if(food instanceof Flower)
                removeSelfFromGrid();
            return foodLoc;
    }
   
    /**
     * Returns the previous location
     * @return the previous location
     */
    public Location getPrev()
    {
        return prev;
    }
   
    /**
     * Returns whether the shrimp has moved
     * @return whether the shrimp has moved
     */
    public boolean getMoved()
    {
        return moved;
    }
   
    /**
     * Allows whether the shrimp has moved or not to be set
     * @param hasMoved the new value for moved
     */
    public void setMoved(boolean hasMoved)
    {
        moved = hasMoved;

    }
}