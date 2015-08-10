package com.service.startandbindservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	//不管是startService还是bindService，它都是第一个启动
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("oncreate!!!!!!!!!!");
	}
	//bindService启动时调用
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind!!!!!!!!!!");
		return null;
	}
	//unbindService时调用
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("onUnbind!!!!!!!!!!");
		return super.onUnbind(intent);
	}

	//startService启动时调用
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand!!!!!!!!!!");
		return super.onStartCommand(intent, flags, startId);
	}

	//不管是stopService还是unbindService调用，它都会被调用
	@Override
	public void onDestroy() {
		System.out.println("onDestroy!!!!!!!!!!");
		super.onDestroy();
	}


	
}
