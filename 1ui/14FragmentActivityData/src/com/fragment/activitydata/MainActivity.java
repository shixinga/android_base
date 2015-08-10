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
		//把fragment02的界面显示至帧布局中
    	//创建fragment对象
		//获取fragment管理器
		FragmentManager fm = getFragmentManager();
		//打开事务
		FragmentTransaction ft = fm.beginTransaction();
		//把内容显示至帧布局
		ft.replace(R.id.fl, fragment01);
		//提交
		ft.commit();
		
	}

	//打开Fragment01界面
	public void getFragment01OnClick(View view) {
		fragment01 = new Fragment01();
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fl, fragment01);
		fragmentTransaction.commit();
	}
	//打开Fragment02界面
	public void getFragment02OnClick(View view) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fl, fragment02);
		fragmentTransaction.commit();
	}
	
	//把data提交到fragment02中的TextView中
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
