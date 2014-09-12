package org.akbkuku.game2048LiveView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.sonyericsson.extras.liveview.plugins.LiveViewAdapter;
import com.sonyericsson.extras.liveview.plugins.PluginConstants;

public class GameBoard {
	
	public static final int
		UP=0,
		DOWN=1,
		LEFT=2,
		RIGHT=3;
		
	
	public static int gridPX[][][] = {
		{{5,5},{35,5},{65,5},{95,5}},
		{{5,35},{35,35},{65,35},{95,35}},
		{{5,65},{35,65},{65,65},{95,65}},
		{{5,95},{35,95},{65,95},{95,95}}
		};

	protected int boardValues[][] = {
			{0,0,256,0},
			{2048,0,2,0},
			{0,0,2,4},
			{0,0,32,0}
			};  
	
	ArrayList<int[]> empties = new ArrayList<int[]>();
	LiveViewAdapter mLiveViewAdapter;
	int mPluginId;
	Context context;
	
	Bitmap background;

	
	public GameBoard(LiveViewAdapter mLiveViewAdapter, int mPluginId, Context context)
	{
		this.mLiveViewAdapter = mLiveViewAdapter;
		this.mPluginId = mPluginId;
		this.context = context;
		
		newGame();

	    // Get bitmaps
		background = BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.background));
	}
	
	public void drawBoard()
	{
        mLiveViewAdapter.sendImageAsBitmap(mPluginId, 0, 0, background);
		for (int x=0;x < 4;x++)
		{

			for (int y=0;y < 4;y++)
			{
				if (boardValues[y][x] != 0)
				{
                    mLiveViewAdapter.sendImageAsBitmap(mPluginId, GameBoard.gridPX[y][x][0],GameBoard.gridPX[y][x][1], getBitmap(boardValues[y][x]));
					
				}
			}
		}
	}
	
	public void newGame()
	{
	    Log.d(PluginConstants.LOG_TAG_GAME, "--New Game--");
		reset();
		addPiece();
		addPiece();
	}
	
	public void reset()
	{
	    Log.d(PluginConstants.LOG_TAG_GAME, "Clearing Board");		
		// Set all spaces to empty
	    getEmpties();
		for (int x=0;x < 4;x++)
		{

			for (int y=0;y < 4;y++)
			{
				boardValues[y][x] = 0;
			}
			
		}
		
	}
	
	private void getEmpties()
	{

	    Log.d(PluginConstants.LOG_TAG_GAME, "Getting Empty Spaces");		
		empties.clear();
		for (int x=0;x < 4;x++)
		{

			for (int y=0;y < 4;y++)
			{
				if (boardValues[y][x] == 0)
				{
					int[] loc = {y,x};
					empties.add(loc);
				}
			}
			
		}
	}
	
	private boolean addPiece()
	{
	    Log.d(PluginConstants.LOG_TAG_GAME, "Adding new piece");
		
	    getEmpties();
		// Check for empty spaces
		if ( empties.size() == 0 )
		{
		    Log.d(PluginConstants.LOG_TAG_GAME, "Out of empty Spaces");
			return false;
		}
		
	    Random rand = new Random();
	    int emptyToFill,
	    	chance,
	    	value;
	    
		boolean notAdded = true;
		while(notAdded)
		{
		    Log.d(PluginConstants.LOG_TAG_GAME, "New piece not added yet");
			emptyToFill = rand.nextInt(empties.size());
			
			chance = rand.nextInt(11);
			if (chance > 8)
			{
				value = 4;
			}
			else
			{
				value = 2;
			}
			
			boardValues[empties.get(emptyToFill)[0]][empties.get(emptyToFill)[1]] = value;
			empties.remove(emptyToFill);
			notAdded = false;
		    Log.d(PluginConstants.LOG_TAG_GAME, "New piece added");
			
			
		}
		return true;
	}
	
	public void slide(int direction)
	{
		switch (direction)
		{
			case GameBoard.UP:
			    Log.d(PluginConstants.LOG_TAG_GAME, "Slide Up");		
				moveAll(0,-1);
				break;
			case GameBoard.DOWN:
			    Log.d(PluginConstants.LOG_TAG_GAME, "Slide Down");	
				moveAll(0,1);
				break;
			case GameBoard.LEFT:
			    Log.d(PluginConstants.LOG_TAG_GAME, "Slide Left");	
				moveAll(-1,0);
				break;
			case GameBoard.RIGHT:
			    Log.d(PluginConstants.LOG_TAG_GAME, "Slide Right");	
				moveAll(1,0);
				break;
		}
		//TODO - Need to test that a move was made before adding
		addPiece();
	}
	
	private void moveAll(int xM, int yM)
	{
		for (int x=0;x < 4;x++)
		{

			for (int y=0;y < 4;y++)
			{
				// Check if empty
				if(boardValues[y][x] != 0)
				{
					
					
					int tx = x,
						ty=y;
					boolean stillMoving = true;
					while(stillMoving)
					{
						if((tx+xM>-1 && tx+xM<4) && (ty+yM>-1 && ty+yM<4) && boardValues[ty+yM][tx+xM] == 0  )
						{
							boardValues[ty+yM][tx+xM] = boardValues[ty][tx];
							boardValues[ty][tx] = 0;
							tx=tx+xM;
							ty=ty+yM;
							
						}
						else if((tx+xM>-1 && tx+xM<4) && (ty+yM>-1 && ty+yM<4) && boardValues[ty+yM][tx+xM] == boardValues[ty][tx]  )
						{

						    Log.d(PluginConstants.LOG_TAG_GAME, "Merging ("+(ty)+","+(tx)+") with ("+(ty+yM)+","+(tx+xM)+") to create a: "+boardValues[ty][tx]*2);	
							boardValues[ty+yM][tx+xM] = boardValues[ty][tx]*2;
							boardValues[ty][tx] = 0;
							tx=tx+xM;
							ty=ty+yM;
							
						}
						else
						{
							stillMoving = false;
						}
					}
				}
			}
			
		}
		
	}
	
	
	private Bitmap getBitmap(int value)
	{
		switch(value)
		{
				
			case 2:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t2));
		
			case 4:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t4));
		
			case 8:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t8));
		
			case 16:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t16));
		
			case 32:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t32));
		
			case 64:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t64));
		
			case 128:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t128));
		
			case 256:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t256));
		
			case 512:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t512));
		
			case 1024:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t1024));
		
			case 2048:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t2048));
		
			case 4096:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t4096));
		
			case 8192:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t8192));
		
			case 16384:

				return BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.t16384));
				
				
		}
		return background;
	}
}
