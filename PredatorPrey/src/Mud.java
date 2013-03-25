import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Iterator;
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
		
		public Actor getActor()
		{
			return mAct;
		}
	}
	
	private Queue<ActorData> mStoredActors = new LinkedList<ActorData>();
	private ArrayList<Actor> mIgnoreActors = new ArrayList<Actor>();
	private long mCurrentTick = 0;
	
	@Override
	public void act()
	{
		mCurrentTick++;
		ArrayList<Location> neighborLocs = getGrid().getOccupiedAdjacentLocations(getLocation());
		ArrayList<Actor> neighbors = new ArrayList<Actor>();
		for (Location loc : neighborLocs)
		{
			neighbors.add(getGrid().get(loc));
		}
		captureActors(neighbors);
		trimIgnoreList(neighbors);
		releaseActors();
	}
	
	private void captureActors(ArrayList<Actor> neighbors)
	{
		for (Actor act : neighbors)
		{
			if (act != null) // Don't see why this would ever fail, but let's be safe
			{
				if (!mIgnoreActors.contains(act))
				{
					mStoredActors.offer(new ActorData(act, mCurrentTick + CAUGHT_TIME));
				}
			}
		}
	}
	
	private void releaseActors()
	{
		boolean done = false;
		while (!done)
		{
			ActorData data = mStoredActors.peek();
			if (data == null || data.getReleaseTime() > mCurrentTick)
			{
				done = true;
			}
			else
			{
				mIgnoreActors.add(data.getActor());
				mStoredActors.poll().restoreActor();
			}
		}
	}
	
	private void trimIgnoreList(ArrayList<Actor> neighbors)
	{
		Iterator<Actor> it = mIgnoreActors.iterator();
		while(it.hasNext())
		{
			Actor act = it.next();
			if (!neighbors.contains(act))
			{
				it.remove();
			}
		}
	}
}
