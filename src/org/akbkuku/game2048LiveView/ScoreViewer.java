package org.akbkuku.game2048LiveView;

import com.sonyericsson.extras.liveview.plugins.PluginConstants;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.Log;

public class ScoreViewer extends LiveViewActivity{
 
	@Override
	public void buildImage() {
	    Log.d(PluginConstants.LOG_TAG_GAME, "Displaying Score");		
		Bitmap background = BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.scores_background));
		// Print Background
		canvas.drawBitmap(background, 0, 0,null);

	    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

	    
		paint.setTextAlign(Align.CENTER);
		paint.setTextSize(18); 
	    
		// TODO Auto-generated method stub 
		paint.setColor(Color.argb(255, 120, 110, 100)); 
		canvas.drawText("Current", 64, 26, paint);
		paint.setColor(Color.WHITE); 
		canvas.drawText(""+SandboxPluginService.score, 64, 50, paint);

		paint.setColor(Color.argb(255, 120, 110, 100)); 
		canvas.drawText("Highest", 64, 82, paint);
		paint.setColor(Color.WHITE); 
		canvas.drawText(""+SandboxPluginService.highScore, 64, 105, paint);
		
	}

}
