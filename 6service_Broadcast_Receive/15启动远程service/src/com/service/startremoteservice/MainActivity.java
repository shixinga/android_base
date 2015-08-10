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
 * Զ��service��service��ͬ��app�е���
 * ����service��sevice��ͬһ��app�е���
 * 
 * ��Ϊ��Զ�̷���service������������һ��app��service��
 * ���Ա����ʵ�service�����Ǳ���ʽ����
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

		//service���ӳɹ�����õķ���
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}

		//service����ʧ�ܺ���õķ���
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
