package org.akbkuku.game2048LiveView;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.sonyericsson.extras.liveview.plugins.LiveViewAdapter;

public class GameBoard {
	
	public static final String
		UP="UP",
		DOWN="DOWN",
		LEFT="LEFT",
		RIGHT="RIGHT";
		
	
	public static int gridPX[][][] = {
		{{5,5},{35,5},{65,5},{95,5}},
		{{5,35},{35,35},{65,35},{95,35}},
		{{5,65},{35,65},{65,65},{95,65}},
		{{5,95},{35,95},{65,95},{95,95}}
		};

	private final static int emptyBoard[][] = {
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
			};  
	
	protected int boardValues[][] = {
			{0,0,256,0},
			{2048,0,2,0},
			{0,0,2,4},
			{0,0,32,0}
			};  
	LiveViewAdapter mLiveViewAdapter;
	int mPluginId;
	Context context;
	
	Bitmap background;

	
	public GameBoard(LiveViewAdapter mLiveViewAdapter, int mPluginId, Context context)
	{
		this.mLiveViewAdapter = mLiveViewAdapter;
		this.mPluginId = mPluginId;
		this.context = context;
		
		//newGame();

	    // Get bitmaps
		background = BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.background));
	}
	
	public void drawBoard()
	{
		newGame();
        mLiveViewAdapter.sendImageAsBitmap(mPluginId, 0, 0, background);
		for (int x=0;x < 4;x++)
		{

			for (int y=0;y < 4;y++)
			{
				if (boardValues[x][y] != 0)
				{
                    mLiveViewAdapter.sendImageAsBitmap(mPluginId, GameBoard.gridPX[x][y][0],GameBoard.gridPX[x][y][1], getBitmap(boardValues[x][y]));
					
				}
			}
		}
	}
	
	public void newGame()
	{
		boardValues = emptyBoard;  
		
		addPiece();
		addPiece();
	}
	
	private void addPiece()
	{
	    Random rand = new Random();
	    int xPos,
	    	yPos,
	    	chance,
	    	value;
	    
		boolean notAdded = true;
		while(notAdded)
		{
			xPos = rand.nextInt(4);
			yPos = rand.nextInt(4);
			if (boardValues[xPos][yPos] != 0)
			{
				chance = rand.nextInt(11);
				if (chance == 10)
				{
					value = 4;
				}
				else
				{
					value = 2;
				}
				
				boardValues[xPos][yPos] = value;
			}
			
		}
	}
	
	public void slide(String direction)
	{
		
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
