import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


public class PredatorPreyRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		Actor catfish = new Catfish();
		Actor catfish2 = new Catfish();
		catfish2.setDirection(45);
		catfish2.setColor(Color.GREEN);
		Actor catfish3 = new Catfish();
		catfish3.setDirection(90);
		catfish3.setColor(Color.YELLOW);
		Actor mussel = new Mussel();
		world.add(new Location(7, 8), catfish);
		world.add(new Location(4, 5), catfish2);
		world.add(new Location(1, 8), catfish3);
		world.add(new Location(2, 3), mussel);
		world.show();
	}

}
