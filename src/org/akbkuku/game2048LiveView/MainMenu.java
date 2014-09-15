package org.akbkuku.game2048LiveView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.sonyericsson.extras.liveview.plugins.AbstractPluginService;
import com.sonyericsson.extras.liveview.plugins.LiveViewAdapter;

public class MainMenu extends LiveViewActivity {

	// Bitmaps
	Bitmap menuBackground,
			selectorStart,
			selectorScores,
			currentSelector;
    Paint paint = new Paint();
	
	public final static int 
		START = 0,
		SCORES = 1;
				
	private int selectedItem = START;
	/**
	 * GameBoard
	 * 
	 * An implementation of the game 2048 for the Sony LiveView
	 * 
	 * @param mLiveViewAdapter
	 * @param mPluginId
	 * @param context
	 */
	public MainMenu()
	{
	    // Get bitmaps
		menuBackground = BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.menu_background));
		selectorStart = BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.menu_select));

        Matrix matrix = new Matrix();
        matrix.postRotate(180);
		selectorScores = Bitmap.createBitmap(selectorStart, 0, 0, selectorStart.getWidth(), selectorStart.getHeight(), matrix, true);
		
		currentSelector = selectorStart;
	}

	@Override
	public void buildImage() {

		canvas.drawBitmap(menuBackground, 0, 0, paint);
		
		canvas.drawBitmap(currentSelector, 4, 60, paint);
		canvas.drawBitmap(currentSelector, 112, 60, paint);
		
	}
	
	public void select(int menuItem)
	{
		switch(menuItem)
		{
			case START:
				selectedItem = START;
				currentSelector = selectorStart;
				break;
				
			case SCORES:
				selectedItem = SCORES;
				currentSelector = selectorScores;
				
				
				break;
		}
	}
	
	public int getSelected(){
		return selectedItem;
	}
}
