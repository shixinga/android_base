package com.service.xxxx;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.csx.service.IPay;
import com.csx.service.IPay.Stub;
/**
 * 
 * ###AIDL
* Android interface definition language
* ���̼�ͨ��
	1. ��Զ�̷���ķ�����ȡ��һ�������Ľӿ�java�ļ�
	2. �ѽӿ�java�ļ��ĺ�׺���ĳ�aidl,Ȼ�󽫸�aidl�ļ������interface�ͺ�����publicȥ��
	3. ���Զ����ɵ�IPay.java�ļ��У���һ����̬������Stub�����Ѿ��̳���binder�࣬ʵ����Ipay�ӿڣ����������µ��м���
	4. ��aidl�ļ�����ճ����17��Ŀ��ճ����ʱ��ע�⣬aidl�ļ����ڵİ��������16��Ŀ��aidl���ڵİ���һ��
	5. ��17��Ŀ�У�ǿת�м��˶���ʱ��ֱ��ʹ��Stub.asInterface����

 * 
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	private Intent intent;
	private MyServiceConn conn;
	private IPay iPay; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent();
		intent.setAction("com.csx.payxxxx");
		conn = new MyServiceConn();
		bindService(intent, conn, BIND_AUTO_CREATE);
	}

	class MyServiceConn implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// ʹ��aidl���Զ����ɵķ�����ǿת
			iPay = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	public void payOnClick(View view) {
		try {
			//����Զ�̷����֧������
			iPay.pay();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
