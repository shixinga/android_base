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
		//���ػ�����ı���ͼ,��bmSrcΪֻ��ģʽ��������Ҫcopy
		Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
		//����bitmap��copy
		bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
		paint = new Paint();
		canvas = new Canvas(bmCopy);
		//����
		canvas.drawBitmap(bmSrc, new Matrix(), paint);
		
		
		iv_canvas.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				//�û���ָ�Ӵ���Ļ
				case MotionEvent.ACTION_DOWN:
//					System.out.println("������");
					startX = (int) event.getX();
					startY = (int) event.getY();
					break;
				//�û���ָ����Ļ�ƶ�
				case MotionEvent.ACTION_MOVE:
//					System.out.println("���ƶ�");
					int x = (int) event.getX();
					int y = (int) event.getY();
					canvas.drawLine(startX, startY, x, y, paint);
					//ÿ�λ������֮�󣬱��λ��ƵĽ�����������һ�λ��Ƶĳ�ʼ����
					startX = x;
					startY = y;
					iv_canvas.setImageBitmap(bmCopy);
					break;
				//�û���ָ�뿪��Ļ
				case MotionEvent.ACTION_UP:
					
//					System.out.println("������");
					break;

				default:
					break;
				}
				//if return true:����ϵͳ����������¼�����������
				//if return false:����ϵͳ����������¼��Ҳ�������ʱϵͳ��Ѵ����¼����ݸ�imageview�ĸ��ڵ�
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
	//save the ͼƬ
	public void saveOnClick(View view) {
		File file = new File(getFilesDir(), "dage.png");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		bmCopy.compress(CompressFormat.PNG, 100, fos);
		
		//����sd�������㲥
//		Intent intent = new Intent();
//		intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
//		intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
//		sendBroadcast(intent);
		
	}

}
