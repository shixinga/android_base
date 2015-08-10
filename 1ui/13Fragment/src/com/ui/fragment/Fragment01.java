package com.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment01 extends Fragment {

	//返回的view对象会作为fragment01的内容显示在屏幕上
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment01, null);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("01create");
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("01start");
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("01resume");
	}
	
	@Override
	public void onPause() {
		super.onPause();
		System.out.println("01pause");
	}
	
	@Override
	public void onStop() {
		super.onStop();
		System.out.println("01stop");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("01destroy");
	}
}
