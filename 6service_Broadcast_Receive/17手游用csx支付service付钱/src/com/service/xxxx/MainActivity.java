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
* 进程间通信
	1. 把远程服务的方法抽取成一个单独的接口java文件
	2. 把接口java文件的后缀名改成aidl,然后将该aidl文件里面的interface和函数的public去掉
	3. 在自动生成的IPay.java文件中，有一个静态抽象类Stub，它已经继承了binder类，实现了Ipay接口，这个类就是新的中间人
	4. 把aidl文件复制粘贴到17项目，粘贴的时候注意，aidl文件所在的包名必须跟16项目中aidl所在的包名一致
	5. 在17项目中，强转中间人对象时，直接使用Stub.asInterface（）

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
			// 使用aidl中自动生成的方法来强转
			iPay = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	public void payOnClick(View view) {
		try {
			//调用远程服务的支付方法
			iPay.pay();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
