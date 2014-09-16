package org.akbkuku.game2048LiveView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;


public class MainMenu extends LiveViewActivity {

	// Bitmaps
	Bitmap menuBackground,
			selectorStart,
			selectorScores,
			currentSelector;
	
	// Paint to define text display settings.
    Paint paint = new Paint();
    
	// Menu Options
	public final static int 
		START = 0,
		SCORES = 1;
	
	// Set default option
	private int selectedItem = START;
	
	/**
	 * MainMenu
	 * 
	 * Provides a menu to see scores or play the game
	 * 
	 */
	public MainMenu()
	{
	    // Get bitmaps
		menuBackground = BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.menu_background));
		selectorStart = BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.menu_select));

		// Rotate selector image to select bottom choice
        Matrix matrix = new Matrix();
        matrix.postRotate(180);
		selectorScores = Bitmap.createBitmap(selectorStart, 0, 0, selectorStart.getWidth(), selectorStart.getHeight(), matrix, true);
		
		currentSelector = selectorStart;
	}

	/**
	 * buildImage
	 * 
	 * Puts menu options together and adds text
	 */
	@Override
	public void buildImage() {
		
		// Draw background
		canvas.drawBitmap(menuBackground, 0, 0, paint);
		
		// Set text settings
		paint.setColor(Color.WHITE); 
		paint.setTextAlign(Align.CENTER);
		paint.setTextSize(18);
		
		// Choose text to display for going to the game
		String startText = "Start";
		if (SandboxPluginService.score != 0)
		{
			startText = "Resume";
		}
		if(GameBoard.gameover)
		{
			startText = "Start";
		}
		
		// Print text on the buttons
		canvas.drawText(startText, 64, 69, paint);
		canvas.drawText("Scores", 64, 106, paint);
	    
		// Print the selector
		canvas.drawBitmap(currentSelector, 4, 60, paint);
		canvas.drawBitmap(currentSelector, 112, 60, paint);
		
	}
	
	/**
	 * select
	 * 
	 * Changes the selector to the specified option
	 * 
	 * @param menuItem
	 */
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
	
	/**
	 * getSelected
	 * 
	 * @return Returns int of the selected item
	 */
	public int getSelected(){
		return selectedItem;
	}
}
