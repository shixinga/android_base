package com.service.banzheng;

import com.service.banzheng.LeaderBindService.ZhouMi;

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

//	private ZhouMi zhouMi;
	private IBanZheng iBanZheng;
	private Intent intent;
	private MyServiceConnection conn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent(this, LeaderBindService.class);
		conn = new MyServiceConnection();
		//绑定service
		bindService(intent, conn, BIND_AUTO_CREATE);
	}
	
	public void banZhengOnClick(View view) {
		//屁民不能和领导打麻将的，只有秘书能
//		zhouMi.daMaJiang();
		iBanZheng.qianXian();
		
	}

	class MyServiceConnection implements ServiceConnection {

		//service链接成功时才调用的函数,第二个参数是LeaderBindService
		//中的onBind()的返回值
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
//			zhouMi = (ZhouMi) service;
			iBanZheng = (IBanZheng) service;
		}

		//service链接失败时调用的函数
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
