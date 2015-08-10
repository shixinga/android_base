package com.service.startandbindservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	//������startService����bindService�������ǵ�һ������
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("oncreate!!!!!!!!!!");
	}
	//bindService����ʱ����
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind!!!!!!!!!!");
		return null;
	}
	//unbindServiceʱ����
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("onUnbind!!!!!!!!!!");
		return super.onUnbind(intent);
	}

	//startService����ʱ����
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand!!!!!!!!!!");
		return super.onStartCommand(intent, flags, startId);
	}

	//������stopService����unbindService���ã������ᱻ����
	@Override
	public void onDestroy() {
		System.out.println("onDestroy!!!!!!!!!!");
		super.onDestroy();
	}


	
}
