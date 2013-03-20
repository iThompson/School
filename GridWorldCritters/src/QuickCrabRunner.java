import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;


public class QuickCrabRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		for (int i = 0; i < 20; i++)
		{
			world.add(new Flower());
		}
		world.add(new QuickCrab());
		world.show();

	}

}
