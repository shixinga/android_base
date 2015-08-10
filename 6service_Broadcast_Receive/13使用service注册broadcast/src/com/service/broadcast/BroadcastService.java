package com.service.broadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class BroadcastService extends Service {

	private ScreenBroadcastReceiver sbr;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		//1.�����㲥�����߶���
		sbr = new ScreenBroadcastReceiver();
		//2.����intent-filter����
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		filter.addAction(Intent.ACTION_SCREEN_ON);
		
		//3.ע��㲥������
		registerReceiver(sbr, filter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//���ע��
		unregisterReceiver(sbr);
	}
	
	

}
