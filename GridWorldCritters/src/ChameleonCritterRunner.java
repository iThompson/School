import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;

import java.awt.Color;


public class ChameleonCritterRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		for (int i = 0; i < 20; i++)
		{
			float r = (float) Math.random();
			float b = (float) Math.random();
			float g = (float) Math.random();
			world.add(new Flower(new Color(r, g, b)));
		}
		world.add(new ChameleonCritter());
		world.show();
	}

}
