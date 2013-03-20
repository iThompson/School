import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;


public class RockHoundRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		for (int i = 0; i < 20; i++)
		{
			world.add(new Rock());
		}
		world.add(new RockHound());
		world.show();
	}

}
