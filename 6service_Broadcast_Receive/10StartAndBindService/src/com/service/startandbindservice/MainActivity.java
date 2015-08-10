package com.service.startandbindservice;

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
 * startService & bindService 的区别
 * 
 *  ①startService:一旦被acticity开启，就和activity一毛钱关系都没有，但关闭服务还是通过
 *  				activity里面的Button关闭
 *   bindService:一旦被activity开启，就和activity相关联，当activity被destroy时，它也被
 *   				destroy（即也同时被调用destroy方法）
 *  ②startService：该函数启动的service所在的进程属于service进程
 * 	 bindService：该函数启动的service所在的进程不属于service进程
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
		intent = new Intent(this, MyService.class);
		conn = new MyConnectionService();
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
	
	class MyConnectionService implements ServiceConnection  {
		//服务连接成功时，此方法调用
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}
		//服务失去连接时，此方法调用
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
