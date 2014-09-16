package org.akbkuku.game2048LiveView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.sonyericsson.extras.liveview.plugins.AbstractPluginService;
import com.sonyericsson.extras.liveview.plugins.LiveViewAdapter;

public abstract class LiveViewActivity {


	// Current Running Info
	static Context context;
	
	Bitmap image = Bitmap.createBitmap(128, 128, Bitmap.Config.RGB_565);
	Canvas canvas = new Canvas(image);

	/**
	 * An basic layout for activities for the LiveView
	 * 
	 * @param mLiveViewAdapter
	 * @param mPluginId
	 * @param context
	 * @return 
	 */
	public static void setup(Context context)
	{
		LiveViewActivity.context = context;
	}
	
	/**
	 * buildImage
	 * 
	 * Put canvas draws here. Is called in draw before sending image to screen
	 */
	public abstract void buildImage();
	
	/**
	 * draw
	 * 
	 * Calls buildImage and draws the image bitmap to the LiveView
	 */
	public void draw()
	{
		buildImage();
		AbstractPluginService.mLiveViewAdapter.sendImageAsBitmap(AbstractPluginService.mPluginId, 0, 0, image);
	}
	
	/**
	 * clear
	 * 
	 * Clears the LiveView display.
	 */
	public void clear()
	{
		AbstractPluginService.mLiveViewAdapter.clearDisplay(AbstractPluginService.mPluginId);
	}
}
