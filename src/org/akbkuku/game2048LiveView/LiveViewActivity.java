package org.akbkuku.game2048LiveView;

import android.content.Context;
import android.graphics.Bitmap;

import com.sonyericsson.extras.liveview.plugins.LiveViewAdapter;

public abstract class LiveViewActivity {


	// Current Running Info
	LiveViewAdapter mLiveViewAdapter;
	int mPluginId;
	Context context;

	/**
	 * LiveViewActivity
	 * 
	 * An basic layout for activities for the LiveView
	 * 
	 * @param mLiveViewAdapter
	 * @param mPluginId
	 * @param context
	 */
	public LiveViewActivity(LiveViewAdapter mLiveViewAdapter, int mPluginId, Context context)
	{
		this.mLiveViewAdapter = mLiveViewAdapter;
		this.mPluginId = mPluginId;
		this.context = context;
	}
	
	public abstract void draw();
	
	public void clear()
	{
        mLiveViewAdapter.clearDisplay(mPluginId);
	}
}
