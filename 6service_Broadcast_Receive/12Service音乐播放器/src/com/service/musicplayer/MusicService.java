package com.service.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new MusicSecretary();
	}

	//做个中间者，负责传递acticity和service之间的data
	class MusicSecretary extends Binder implements IMusicPlayer {

		@Override
		public void play() {
			MusicService.this.play();
		}

		@Override
		public void pause() {
			MusicService.this.pause();
		}
		
	}
	
	public void play() {
		Toast.makeText(this, "开始播放音乐", 0).show();
	}
	
	public void pause() {
		Toast.makeText(this, "暂停音乐！", 0).show();
	}
}
