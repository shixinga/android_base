package com.service.musicplayer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private Intent intent;
	private IMusicPlayer imp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent(this, MusicService.class);
		//混合调用
        //为了把服务所在进程变成服务进程
		//因为bindService和acticity共存亡，而startService不是和acticity共存亡
		//所以在玩其他应用时它还可以继续play
		startService(intent);
		
		//因为音乐要play,而play()在service里面定义，所以要想在acticity
		//中调用service里面的函数，就必须要用一个中间者，所以用bindService
		bindService(intent, new MusicServiceConn(), BIND_AUTO_CREATE);
		
		//注意上面的两行顺序不能change，否则有意想不到的结果！！！！！！
	}

	class MusicServiceConn implements ServiceConnection {

		//当service链接success时调用
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			imp = (IMusicPlayer) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	public void playOnClick(View view) {
		imp.play();
	}
	
	public void pauseOnClick(View view) {
		imp.pause();
	}
}
