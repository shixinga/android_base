package com.media.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
/**
 * ###SurfaceView
* ˫���弼��
* ���������(ռ�ڴ��)
* ֻҪ���ɼ����Ͳ��ᴴ�����ɼ�ʱ���Żᴴ��
* ֻҪ���ɼ����ͻ�����
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	private MediaPlayer player;
	static int currentPosition;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SurfaceView sv = (SurfaceView) findViewById(R.id.sv_show);
		//�õ�surfaceview�Ŀ�����
		final SurfaceHolder sh = sv.getHolder();
		
//		sleep(200)�����ȴ�surfaceView�������ȫ����
//		Thread t = new Thread(){
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					sleep(200);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				runOnUiThread(new Runnable() {
//					@Override
//					public void run() {
//						MediaPlayer player = new MediaPlayer();
//						player.reset();
//						try {
//							player.setDataSource("sdcard/2.3gp");
//							player.setDisplay(sh);
//							player.prepare();
//							player.start();
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} 
//						
//					}
//				});
//				
//			}
//		};
//		t.start();
		
		sh.addCallback(new Callback() {
			
			
			//surfaceView����ʱ����
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				//ÿ��surfaceview����ʱ��ͬʱֹͣ������Ƶ
				if(player != null){
					currentPosition = player.getCurrentPosition();
					player.stop();
					player.release();
					player = null;
				}
				
			}
			//surfaceView����ʱ����
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				//ÿ��surfaceView����ʱ��ȥ������Ƶ
				if(player == null){
					player = new MediaPlayer();
					player.reset();
					try {
						player.setDataSource("sdcard/2.3gp");
						player.setDisplay(sh);
						player.prepare();
						player.start();
						player.seekTo(currentPosition);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				
			}
			//surfaceView�ṹ�ı�ʱ����
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
