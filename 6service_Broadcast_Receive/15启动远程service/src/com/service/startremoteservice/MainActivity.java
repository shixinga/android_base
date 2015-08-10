package com.service.startremoteservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
/**
 * 
 * 远程service：service不同的app中调用
 * 本地service：sevice在同一个app中调用
 * 
 * 因为是远程访问service（即访问另外一个app的service）
 * 所以被访问的service必须是被隐式访问
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	private Intent intent;
	private ServiceConnection conn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent();
		intent.setAction("com.xxxxx.remoteservice");
		conn = new MyServiceConn();
	}

	public void startServiceOnClick(View view) {
		startService(intent);
	}
	public void stopServiceOnClick(View view) {
		stopService(intent);
	}
	public void bindServiceOnClick(View view) {
		bindService(intent, conn, BIND_AUTO_CREATE);
	}
	public void unbindServiceOnClick(View view) {
		unbindService(conn);
	}
	
	class MyServiceConn implements ServiceConnection {

		//service链接成功后调用的方法
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}

		//service链接失败后调用的方法
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
