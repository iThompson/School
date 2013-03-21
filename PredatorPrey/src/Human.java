import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;


public class Human extends Actor
{
	private static final double MOVE_CHANCE = 0.75;
	private boolean isHypnotized;
	
	public Human()
	{
		isHypnotized = false;
	}
	
	@Override
	public void act()
	{
		if (!isHypnotized)
		{
			if (canMove() && Math.random() < MOVE_CHANCE)
			{ // 75% chance to move if possible
				move();
			}
			else
			{
				setDirection(getDirection() + Location.HALF_RIGHT);
			}
		}
	}
	
	public boolean canMove()
	{
		Location nextLoc = getLocation().getAdjacentLocation(getDirection());
		Grid<Actor> grd = getGrid();
		if (grd.isValid(nextLoc) && grd.get(nextLoc) == null)
			return true;
		else
			return false;
	}
	
	public void move()
	{
		moveTo(getLocation().getAdjacentLocation(getDirection()));
	}
	
	public void hypnotize()
	{
		isHypnotized = true;
		setColor(Color.RED);
	}
}
