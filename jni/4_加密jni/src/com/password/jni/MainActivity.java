package com.password.jni;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/**
 * ������java����ʵ��md5���ܣ���Ϊjava������Ա�������
 * ����ͨ��jniʵ����c������ʵ�ּ����㷨��c���ѱ�������
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	static {
		System.loadLibrary("hihi");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void getPasswordOnClick(View view) {
		EditText editText = (EditText) findViewById(R.id.ed_password);
		int password = Integer.parseInt(editText.getText().toString());
		Toast.makeText(this, "���ܺ�������ǣ�" + getPassword(password), 0).show();
	}
	
	public native int getPassword(int i);
}
