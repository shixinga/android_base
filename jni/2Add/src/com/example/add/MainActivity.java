package com.example.add;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
/*
 * 
 * ##��������
* findLibrary returned null
	* CPUƽ̨��ƥ��
	* �������ʱ��д���������

* ���ط����Ҳ���
	* ���Ǽ������
	* c�����з�����д����

Application.mk�����ã������ڲ�ͬ�ֻ�cpu���ļ�����
 */
public class MainActivity extends Activity {

	static {
		System.loadLibrary("hh");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void addOnClick(View view) {
		Toast.makeText(this, "3+4=" + add(3,4), 0).show();
	}
	
	public native int add(int i, int j);
}
