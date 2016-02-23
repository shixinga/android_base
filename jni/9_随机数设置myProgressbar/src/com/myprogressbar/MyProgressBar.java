package com.myprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class MyProgressBar extends View {

	private int currentData;
	private Paint paint;
	public final static int MAX = 100;
	public MyProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MyProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyProgressBar(Context context) {
		super(context);
	}
	
	
//绘图
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		paint = new Paint();
		if(currentData > 80) {
			paint.setColor(Color.RED);
		} else if(currentData > 50) {
			paint.setColor(Color.BLUE);
		} else {
			paint.setColor(Color.GREEN);
		}
		canvas.drawRect(10, 10 + MyProgressBar.MAX - currentData, 40, 10 + MyProgressBar.MAX, paint);
		
	}

	public void setCurrentData(int currentData) {
		this.currentData = currentData;
		//invalidate();不能再非UI线程运行,而postInvalidate()可以在非UI线程运行
//		invalidate();
		postInvalidate();
	}


	
}
