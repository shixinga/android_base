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
    	//��ȡfragment������
    	FragmentManager fm = getFragmentManager();
    	//������
    	FragmentTransaction ft = fm.beginTransaction();
    	//��������ʾ��֡����
    	ft.replace(R.id.fl_right, fg3);
    	//�ύ
    	ft.commit();
	}

	public void fragment01OnClick(View view) {
		//��fragment01�Ľ�����ʾ��֡������
    	//����fragment����
		Fragment01 fragment01 = new Fragment01();
		//��ȡfragment������
		FragmentManager fm = getFragmentManager();
		//������
		FragmentTransaction ft = fm.beginTransaction();
		//��������ʾ��֡����
		ft.replace(R.id.fl_right, fragment01);
		//�ύ
		ft.commit();
	}
	public void fragment02OnClick(View view) {
		
		//��fragment01�Ľ�����ʾ��֡������
		//����fragment����
		Fragment02 fragment02 = new Fragment02();
		//��ȡfragment������
		FragmentManager fm = getFragmentManager();
		//������
		FragmentTransaction ft = fm.beginTransaction();
		//��������ʾ��֡����
		ft.replace(R.id.fl_right, fragment02);
		//�ύ
		ft.commit();
	}
	public void fragment03OnClick(View view) {
		
		//��fragment01�Ľ�����ʾ��֡������
		//����fragment����
		Fragment03 fragment03 = new Fragment03();
		//��ȡfragment������
		FragmentManager fm = getFragmentManager();
		//������
		FragmentTransaction ft = fm.beginTransaction();
		//��������ʾ��֡����
		ft.replace(R.id.fl_right, fragment03);
		//�ύ
		ft.commit();
	}
}
