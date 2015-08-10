package com.service.remote;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RemoteService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("obBnid!!!!!!!!");
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("onCreate!!!!!!!!");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand!!!!!!!!");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("onDestroy!!!!!!!!");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	
}
