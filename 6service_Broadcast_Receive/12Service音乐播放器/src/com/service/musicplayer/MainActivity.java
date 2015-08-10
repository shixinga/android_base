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
		//��ϵ���
        //Ϊ�˰ѷ������ڽ��̱�ɷ������
		//��ΪbindService��acticity����������startService���Ǻ�acticity������
		//������������Ӧ��ʱ�������Լ���play
		startService(intent);
		
		//��Ϊ����Ҫplay,��play()��service���涨�壬����Ҫ����acticity
		//�е���service����ĺ������ͱ���Ҫ��һ���м��ߣ�������bindService
		bindService(intent, new MusicServiceConn(), BIND_AUTO_CREATE);
		
		//ע�����������˳����change�����������벻���Ľ��������������
	}

	class MusicServiceConn implements ServiceConnection {

		//��service����successʱ����
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
