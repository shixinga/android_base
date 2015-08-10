package com.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment03 extends Fragment {

	//返回的view对象会作为fragment01的内容显示在屏幕上
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment03, null);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("033create");
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("033start");
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("033resume");
	}
	
	@Override
	public void onPause() {
		super.onPause();
		System.out.println("033pause");
	}
	
	@Override
	public void onStop() {
		super.onStop();
		System.out.println("03stop");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("03destroy");
	}
}
