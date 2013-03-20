import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


public class Human extends Actor
{
	@Override
	public void act()
	{
		if (canMove() && Math.random() < 0.5)
		{ // 50% chance to move if possible
			move();
		}
		else
		{
			setDirection(getDirection() + Location.HALF_RIGHT);
		}
	}
	
	public boolean canMove()
	{
		if (getGrid().get(getLocation().getAdjacentLocation(getDirection())) == null)
			return true;
		else
			return false;
	}
	
	public void move()
	{
		moveTo(getLocation().getAdjacentLocation(getDirection()));
	}
}
