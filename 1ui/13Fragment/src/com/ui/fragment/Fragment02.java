package com.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment02 extends Fragment {

	//���ص�view�������Ϊfragment01��������ʾ����Ļ��
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment02, null);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("02create");
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("02start");
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("02resume");
	}
	
	@Override
	public void onPause() {
		super.onPause();
		System.out.println("022pause");
	}
	
	@Override
	public void onStop() {
		super.onStop();
		System.out.println("022stop");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("022destroy");
	}
}
