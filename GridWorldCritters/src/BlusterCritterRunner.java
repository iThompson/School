import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;

import java.awt.Color;


public class BlusterCritterRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		for (int i = 0; i < 10; i++)
		{
			float r = (float) Math.random();
			float b = (float) Math.random();
			float g = (float) Math.random();
			Critter critter = new BlusterCritter(2);
			critter.setColor(new Color(r, g, b));
			world.add(critter);
		}
		world.show();
	}

}
