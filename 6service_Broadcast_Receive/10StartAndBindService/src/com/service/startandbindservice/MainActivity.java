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
 * startService & bindService ������
 * 
 *  ��startService:һ����acticity�������ͺ�activityһëǮ��ϵ��û�У����رշ�����ͨ��
 *  				activity�����Button�ر�
 *   bindService:һ����activity�������ͺ�activity���������activity��destroyʱ����Ҳ��
 *   				destroy����Ҳͬʱ������destroy������
 *  ��startService���ú���������service���ڵĽ�������service����
 * 	 bindService���ú���������service���ڵĽ��̲�����service����
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
		//�������ӳɹ�ʱ���˷�������
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}
		//����ʧȥ����ʱ���˷�������
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
}
