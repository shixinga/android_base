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

	//�����м��ߣ����𴫵�acticity��service֮���data
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
		Toast.makeText(this, "��ʼ��������", 0).show();
	}
	
	public void pause() {
		Toast.makeText(this, "��ͣ���֣�", 0).show();
	}
}
