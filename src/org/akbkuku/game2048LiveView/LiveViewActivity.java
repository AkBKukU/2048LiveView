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
	 * LiveViewActivity
	 * 
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
	
	public abstract void buildImage();
	
	public void draw()
	{
		buildImage();
		AbstractPluginService.mLiveViewAdapter.sendImageAsBitmap(AbstractPluginService.mPluginId, 0, 0, image);
	}
	
	public void clear()
	{
		AbstractPluginService.mLiveViewAdapter.clearDisplay(AbstractPluginService.mPluginId);
	}
}
