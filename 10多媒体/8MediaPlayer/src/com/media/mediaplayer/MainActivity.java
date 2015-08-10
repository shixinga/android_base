package com.media.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
/**
 * ###SurfaceView
* 双缓冲技术
* 重量级组件(占内存多)
* 只要不可见，就不会创建，可见时，才会创建
* 只要不可见，就会销毁
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
		//拿到surfaceview的控制器
		final SurfaceHolder sh = sv.getHolder();
		
//		sleep(200)秒来等待surfaceView对象的完全创建
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
			
			
			//surfaceView销毁时调用
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				//每次surfaceview销毁时，同时停止播放视频
				if(player != null){
					currentPosition = player.getCurrentPosition();
					player.stop();
					player.release();
					player = null;
				}
				
			}
			//surfaceView创建时调用
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				//每次surfaceView创建时才去播放视频
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
			//surfaceView结构改变时调用
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
