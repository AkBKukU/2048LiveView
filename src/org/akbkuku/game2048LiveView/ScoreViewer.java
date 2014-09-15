package org.akbkuku.game2048LiveView;

import com.sonyericsson.extras.liveview.plugins.PluginConstants;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

public class ScoreViewer extends LiveViewActivity{
 
	@Override
	public void buildImage() {
	    Log.d(PluginConstants.LOG_TAG_GAME, "Displaying Score");		
		Bitmap background = BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.background));
		// Print Background
		canvas.drawBitmap(background, 0, 0,null);

	    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

	    
		paint.setColor(Color.WHITE); 
		paint.setTextSize(20); 
	    
		// TODO Auto-generated method stub
		canvas.drawText("Score: "+SandboxPluginService.score, 0, 20, paint);
	}

}
