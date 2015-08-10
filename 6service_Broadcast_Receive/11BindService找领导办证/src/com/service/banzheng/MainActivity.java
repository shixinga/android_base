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
		//��service
		bindService(intent, conn, BIND_AUTO_CREATE);
	}
	
	public void banZhengOnClick(View view) {
		//ƨ���ܺ��쵼���齫�ģ�ֻ��������
//		zhouMi.daMaJiang();
		iBanZheng.qianXian();
		
	}

	class MyServiceConnection implements ServiceConnection {

		//service���ӳɹ�ʱ�ŵ��õĺ���,�ڶ���������LeaderBindService
		//�е�onBind()�ķ���ֵ
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
//			zhouMi = (ZhouMi) service;
			iBanZheng = (IBanZheng) service;
		}

		//service����ʧ��ʱ���õĺ���
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
