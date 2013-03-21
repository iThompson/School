import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Mud extends Actor
{
	private static final long CAUGHT_TIME = 5;
	
	private class ActorData
	{
		private Actor mAct;
		private Location mLoc;
		private Grid<Actor> mGrd;
		private long mReleaseTime;
		
		public ActorData(Actor act, long releaseTime)
		{
			mAct = act;
			mLoc = act.getLocation();
			mGrd = act.getGrid();
			mReleaseTime = releaseTime;
			
			act.removeSelfFromGrid();
		}
		
		public long getReleaseTime()
		{
			return mReleaseTime;
		}
		
		public void restoreActor()
		{
			mAct.putSelfInGrid(mGrd, mLoc);
		}
	}
	
	private Queue<ActorData> mStoredActors = new LinkedList<ActorData>();
	private ArrayList<Actor> mIgnoreActors = new ArrayList<Actor>();
	private long mCurrentTick = 0;
	
	@Override
	public void act()
	{
		ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
		captureActors(neighbors);
		updateIgnoreList(neighbors);
	}
	
	private void captureActors(ArrayList<Location> neighbors)
	{
		
	}
	
	private void updateIgnoreList(ArrayList<Location> neighbors)
	{
		
	}
}
