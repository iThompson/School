import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.Color;


public class PredatorPreyRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld(/*new BoundedGrid<Actor>(20, 20)*/ new UnboundedGrid<Actor>());
		
		for (int i = 0; i < 10; i++)
		{
			world.add(new Mud());
		}
		
		world.add(new Location(2,5), new Goby());
		world.add(new Location(3,5), new Shrimp());
		for (int i = 0; i < 15; i++)
		{
			world.add(new Flower());
			world.add(new Rock());
		}
		
		Actor catfish = new Catfish();
		Actor catfish2 = new Catfish();
		catfish2.setDirection(45);
		catfish2.setColor(Color.GREEN);
		Actor catfish3 = new Catfish();
		catfish3.setDirection(90);
		catfish3.setColor(Color.YELLOW);
		Actor mussel = new Mussel();
		world.add(catfish);
		world.add(catfish2);
		world.add(catfish3);
		world.add(mussel);
		
		for(int i = 0; i < 20; i++)
			world.add(new Human());
		world.add(new Alien());
		world.show();
	}

}
