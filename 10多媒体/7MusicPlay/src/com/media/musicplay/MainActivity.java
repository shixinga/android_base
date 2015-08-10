package com.media.musicplay;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	private Intent intent;
	private IPlay iPlay;
	private ServiceConnection conn;
	private static SeekBar sb;
	static Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			int duration = bundle.getInt("duration");
			int currentPostition = bundle.getInt("currentPosition");
			//刷新进度条的进度
			sb.setMax(duration);
			sb.setProgress(currentPostition);
		}
		
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sb = (SeekBar) findViewById(R.id.sb);
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				//根据拖动的进度改变音乐播放进度
				int progress = seekBar.getProgress();
				//改变播放进度
				iPlay.seekTo(progress);
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
			}
		});
		intent = new Intent(this, PlayerService.class);
		conn = new MyServiceConn();
		startService(intent);
		bindService(intent, conn, BIND_AUTO_CREATE);
		
	}

	class MyServiceConn implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			iPlay = (IPlay) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	public void playOnClick(View view) {
		iPlay.play();
	}
	public void pauseOnClick(View view) {
		iPlay.pause();
	}
	public void goOnOnClick(View view) {
		iPlay.goOnPlay();
	}
	public void exitOnClick(View view) {
		unbindService(conn);
		stopService(intent);
	}
}
