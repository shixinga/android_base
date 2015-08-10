package com.ui.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private Fragment03 fg3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fg3 = new Fragment03();
    	//获取fragment管理器
    	FragmentManager fm = getFragmentManager();
    	//打开事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//把内容显示至帧布局
    	ft.replace(R.id.fl_right, fg3);
    	//提交
    	ft.commit();
	}

	public void fragment01OnClick(View view) {
		//把fragment01的界面显示至帧布局中
    	//创建fragment对象
		Fragment01 fragment01 = new Fragment01();
		//获取fragment管理器
		FragmentManager fm = getFragmentManager();
		//打开事务
		FragmentTransaction ft = fm.beginTransaction();
		//把内容显示至帧布局
		ft.replace(R.id.fl_right, fragment01);
		//提交
		ft.commit();
	}
	public void fragment02OnClick(View view) {
		
		//把fragment01的界面显示至帧布局中
		//创建fragment对象
		Fragment02 fragment02 = new Fragment02();
		//获取fragment管理器
		FragmentManager fm = getFragmentManager();
		//打开事务
		FragmentTransaction ft = fm.beginTransaction();
		//把内容显示至帧布局
		ft.replace(R.id.fl_right, fragment02);
		//提交
		ft.commit();
	}
	public void fragment03OnClick(View view) {
		
		//把fragment01的界面显示至帧布局中
		//创建fragment对象
		Fragment03 fragment03 = new Fragment03();
		//获取fragment管理器
		FragmentManager fm = getFragmentManager();
		//打开事务
		FragmentTransaction ft = fm.beginTransaction();
		//把内容显示至帧布局
		ft.replace(R.id.fl_right, fragment03);
		//提交
		ft.commit();
	}
}
