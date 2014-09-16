/*
 * Copyright (c) 2010 Sony Ericsson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * 
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.akbkuku.game2048LiveView;

import com.sonyericsson.extras.liveview.plugins.AbstractPluginService;
import com.sonyericsson.extras.liveview.plugins.PluginConstants;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
public class SandboxPluginService extends AbstractPluginService {
    
	Context context = this;

	SharedPreferences sharedPref;
	SharedPreferences.Editor editor;
	
	// Enum for activities
	private enum workers 
	{
		MAINMENU,
		GAMEBOARD,
		SCOREVIEW
	}
	
	// Set default activity
	private workers currentWorker = workers.MAINMENU;
    
    // Our handler.
    private Handler mHandler = null;
    
    // Game Logic
    GameBoard board = null;
    MainMenu mMenu = null;
    ScoreViewer scoreView = null;

    // Score values
    public static int score = 0,
    				highScore = 0;
	
    /**
     * First Start Stage
     * 
     * @see com.sonyericsson.extras.liveview.plugins.AbstractPluginService#onCreate()
     */
	@Override
	public void onCreate() {
		super.onCreate();
	}
    
	/**
	 * Second Start Stage
	 * 
	 * @see com.sonyericsson.extras.liveview.plugins.AbstractPluginService#onStart(android.content.Intent, int)
	 */
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);

		// Create handler.
		if(mHandler == null) {
		    mHandler = new Handler();
		}
		
		// Load high score from file
		sharedPref = context.getSharedPreferences("org.akbkuku.highScore", Context.MODE_PRIVATE);
		editor = sharedPref.edit();
		score = 0;
		highScore = sharedPref.getInt("high_score", highScore);
		
		// Load activities
		LiveViewActivity.setup(context);
		board = new GameBoard();
		mMenu = new MainMenu ();
		scoreView = new ScoreViewer();
	}
	
	/**
	 * Last Stop Stage
	 * 
	 * @see com.sonyericsson.extras.liveview.plugins.AbstractPluginService#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		stopWork();
	}
	
    /**
     * Plugin is sandbox.
     */
    protected boolean isSandboxPlugin() {
        return true;
    }
	
	/**
	 * Must be implemented.
	 * 
	 * PluginService has done connection and registering to the LiveView Service. 
	 * 
	 * If needed, do additional actions here, e.g. 
	 * starting any worker that is needed.
	 */
	protected void onServiceConnectedExtended(ComponentName className, IBinder service) {
		
	}
	
	/**
	 * Must be implemented.
	 * 
	 * PluginService has done disconnection from LiveView and service has been stopped. 
	 * 
	 * Do any additional actions here.
	 */
	protected void onServiceDisconnectedExtended(ComponentName className) {
		
	}

	/**
	 * Must be implemented.
	 * 
	 * PluginService has checked if plugin has been enabled/disabled.
	 * 
	 * The shared preferences has been changed. Take actions needed. 
	 */	
	protected void onSharedPreferenceChangedExtended(SharedPreferences prefs, String key) {
		
	}
	
	/**
	 * startPlugin
	 * 
	 *  Starts when plugin is loaded
	 */
	protected void startPlugin() {
		Log.d(PluginConstants.LOG_TAG, "startPlugin");
		startWork();
	}

	/**
	 * stopPlugin
	 * 
	 *  Starts when plugin is unloaded
	 */	
	protected void stopPlugin() {
		Log.d(PluginConstants.LOG_TAG, "stopPlugin");
		stopWork();
	}

	
	
	/**
	 * startWork
	 * 
	 * Must be implemented. Starts plugin work, if any.
	 */
	protected void startWork() {
            mMenu.draw();
	}
	
	/**
	 * stopWork
	 * 
	 * Must be implemented. Stops plugin work, if any.
	 */
	protected void stopWork() {
		stopUpdates();
	}
	
	/**
	 * button
	 * 
	 * Provides interaction with app using buttons
	 */
	protected void button(String buttonType, boolean doublepress, boolean longpress) {
	    Log.d(PluginConstants.LOG_TAG, "button - type " + buttonType + ", doublepress " + doublepress + ", longpress " + longpress);
		
	    //Check high score
	    if (score > highScore)
	    {
	    	editor.putInt("high_score", score);
	    	editor.commit();
	    	highScore = score;
	    }
	    
	    // Send input to current activity
	    switch(currentWorker)
	    {
	    
	    case MAINMENU:
			if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_UP)) 
			{
				mMenu.select(MainMenu.START);
				mMenu.draw();
			}
			else if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_DOWN)) 
			{
				mMenu.select(MainMenu.SCORES);
				mMenu.draw();
			} 
			else if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_SELECT)) 
			{
	            rumble(PluginConstants.RUMBLE_SHORT);
	            
	            // Open selected activity 
	            if(mMenu.getSelected() == MainMenu.START)
	            {
	            	// Check if game is over and reset if it is
		            currentWorker=workers.GAMEBOARD;
		    		if(GameBoard.gameover)
		    		{
			            board.newGame();
		    		}
		            board.draw();
	            	
	            }
	            else if(mMenu.getSelected() == MainMenu.SCORES)
	            {
		            currentWorker=workers.SCOREVIEW;
		            scoreView.draw();
	            	
	            }
			}
			
	    	break;
	    
	    case GAMEBOARD: 
		    
			if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_UP)) 
			{
				board.slide(GameBoard.UP);
	            board.draw();
			}
			else if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_DOWN)) 
			{
				board.slide(GameBoard.DOWN);
	            board.draw();
			} 
			else if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_LEFT)) 
			{
				board.slide(GameBoard.LEFT);
	            board.draw();
			} 
			else if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_RIGHT)) 
			{
				board.slide(GameBoard.RIGHT);
	            board.draw();
			} 
			else if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_SELECT)) 
			{
	            rumble(PluginConstants.RUMBLE_SHORT);
	            currentWorker=workers.MAINMENU;
	            mMenu.draw();
			}
	    	
	    	break;
	    	
	    case SCOREVIEW:

			if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_UP)) 
			{
				scoreView.draw();
			}
			else if(buttonType.equalsIgnoreCase(PluginConstants.BUTTON_SELECT)) 
			{
	            rumble(PluginConstants.RUMBLE_SHORT);
	            currentWorker=workers.MAINMENU;
	            mMenu.draw();
			}
	    	break;
	    }
	}

	protected void displayCaps(int displayWidthPx, int displayHeigthPx) {
        Log.d(PluginConstants.LOG_TAG, "displayCaps - width " + displayWidthPx + ", height " + displayHeigthPx);
    }

	protected void onUnregistered() throws RemoteException {
		Log.d(PluginConstants.LOG_TAG, "onUnregistered");
		stopWork();
	}

	protected void openInPhone(String openInPhoneAction) {
		Log.d(PluginConstants.LOG_TAG, "openInPhone: " + openInPhoneAction);
	}
	
    protected void screenMode(int mode) {
        Log.d(PluginConstants.LOG_TAG, "screenMode: screen is now " + ((mode == 0) ? "OFF" : "ON"));
        
        if(mode == PluginConstants.LIVE_SCREEN_MODE_ON) {
            startUpdates();
        } else {
        	
            stopUpdates();
        }
    }
    
    /**
     * rumble
     * 
     * A more intuitive interface for controlling the vibration motor.
     * 
     * @param duration Takes: PluginConstants.RUMBLE_SHORT, PluginConstants.RUMBLE_MEDIUM, or PluginConstants.RUMBLE_LONG
     */
    public void rumble(int duration)
    {
        mLiveViewAdapter.vibrateControl(mPluginId, 0, duration);
    }
    
    
    private void stopUpdates() {
    }
    
    private void startUpdates() {
    }
    
    
}