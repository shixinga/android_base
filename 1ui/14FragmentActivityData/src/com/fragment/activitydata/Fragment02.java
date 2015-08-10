package com.fragment.activitydata;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment02 extends Fragment {

	private TextView tv_frag02;
	
	@Override
	public void onAttach(Activity activity) {
		System.out.println("222Attach");
		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		System.out.println("222onDetach");
		super.onDetach();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment02, null);
		tv_frag02 = (TextView) view.findViewById(R.id.tv_frag02);
		System.out.println("0200202onCreateView");
		return view;
	}

	public void setFragment02Text(String text) {
		System.out.println("02ssssettext!!");
		tv_frag02.setText(text);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("0200202onCreate");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		System.out.println("0200202onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		System.out.println("0200202onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("0200202onDestroy");
		super.onDestroy();
	}
	
	
}
