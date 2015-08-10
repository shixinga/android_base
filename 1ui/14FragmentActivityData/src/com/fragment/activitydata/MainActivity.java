package com.fragment.activitydata;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	private FrameLayout fl;
	private EditText et_main;
	
	private Fragment02 fragment02;
	private Fragment01 fragment01;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_main = (EditText) findViewById(R.id.et_main);
		fl = (FrameLayout) findViewById(R.id.fl);
		fragment02 = new Fragment02();
		fragment01 = new Fragment01();
		//��fragment02�Ľ�����ʾ��֡������
    	//����fragment����
		//��ȡfragment������
		FragmentManager fm = getFragmentManager();
		//������
		FragmentTransaction ft = fm.beginTransaction();
		//��������ʾ��֡����
		ft.replace(R.id.fl, fragment01);
		//�ύ
		ft.commit();
		
	}

	//��Fragment01����
	public void getFragment01OnClick(View view) {
		fragment01 = new Fragment01();
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fl, fragment01);
		fragmentTransaction.commit();
	}
	//��Fragment02����
	public void getFragment02OnClick(View view) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fl, fragment02);
		fragmentTransaction.commit();
	}
	
	//��data�ύ��fragment02�е�TextView��
	public void transformToFragOnClick(View view) {
		String text = et_main.getText().toString();
		
		fragment02.setFragment02Text(text);
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fl, fragment02);
		fragmentTransaction.commit();
	}
	
	public void setActivityText(String text) {
		et_main.setText(text);
	}
}
