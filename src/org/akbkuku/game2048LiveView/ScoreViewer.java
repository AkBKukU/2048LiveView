package org.akbkuku.game2048LiveView;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class ScoreViewer extends LiveViewActivity{

	@Override
	public void buildImage() {

	    Paint paint = new Paint();

		paint.setColor(Color.BLACK);
		paint.setStyle(Style.FILL); 
		canvas.drawPaint(paint); 
		paint.setColor(Color.WHITE); 
		paint.setTextSize(20); 
	    
		// TODO Auto-generated method stub
		canvas.drawText("Score: "+SandboxPluginService.score, 0, 0, paint);
	}

}
