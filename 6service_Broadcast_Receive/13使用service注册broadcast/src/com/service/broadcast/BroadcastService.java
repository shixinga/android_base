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
		//1.创建广播接收者对象
		sbr = new ScreenBroadcastReceiver();
		//2.创建intent-filter对象
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		filter.addAction(Intent.ACTION_SCREEN_ON);
		
		//3.注册广播接收者
		registerReceiver(sbr, filter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//解除注册
		unregisterReceiver(sbr);
	}
	
	

}
