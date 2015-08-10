package com.media.paint;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv_canvas;
	private Canvas canvas;
	private Paint paint;

	private Bitmap bmCopy;
	
	int startX;
	int startY;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_canvas = (ImageView) findViewById(R.id.iv_canvas);
		canvas = new Canvas();
		//加载画画板的背景图,该bmSrc为只读模式，所以需要copy
		Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
		//创建bitmap的copy
		bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
		paint = new Paint();
		canvas = new Canvas(bmCopy);
		//绘制
		canvas.drawBitmap(bmSrc, new Matrix(), paint);
		
		
		iv_canvas.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				//用户手指接触屏幕
				case MotionEvent.ACTION_DOWN:
//					System.out.println("被按下");
					startX = (int) event.getX();
					startY = (int) event.getY();
					break;
				//用户手指在屏幕移动
				case MotionEvent.ACTION_MOVE:
//					System.out.println("被移动");
					int x = (int) event.getX();
					int y = (int) event.getY();
					canvas.drawLine(startX, startY, x, y, paint);
					//每次绘制完毕之后，本次绘制的结束坐标变成下一次绘制的初始坐标
					startX = x;
					startY = y;
					iv_canvas.setImageBitmap(bmCopy);
					break;
				//用户手指离开屏幕
				case MotionEvent.ACTION_UP:
					
//					System.out.println("不摸了");
					break;

				default:
					break;
				}
				//if return true:告诉系统，这个触摸事件由我来处理
				//if return false:告诉系统，这个触摸事件我不处理，这时系统会把触摸事件传递给imageview的父节点
				return true;
			}
		});
	}
	
	public void redOnClick(View view) {
		paint.setColor(Color.RED);
	}
	public void greenOnClick(View view) {
		paint.setColor(Color.GREEN);
	}
	public void brushOnClick(View view) {
		paint.setStrokeWidth(8);
	}
	//save the 图片
	public void saveOnClick(View view) {
		File file = new File(getFilesDir(), "dage.png");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		bmCopy.compress(CompressFormat.PNG, 100, fos);
		
		//发送sd卡就绪广播
//		Intent intent = new Intent();
//		intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
//		intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
//		sendBroadcast(intent);
		
	}

}
