package com.fragment.activitydata;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment01 extends Fragment {

	private EditText ed_frag01;

	//注意这里的button不能再布局文件使用onClick属性！！！
	//只能通过id来获取button按钮来setOnClickListener
	//因为Fragment不是activity
	private Button bt_transformDataToActivity;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment01, null);
		ed_frag01 = (EditText) view.findViewById(R.id.et_frag_01);
		bt_transformDataToActivity = 
				(Button) view.findViewById(R.id.bt_transformDataToActivity);
		bt_transformDataToActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String text = ed_frag01.getText().toString();
				((MainActivity)getActivity()).setActivityText(text);
				
			}
		});
System.out.println("01111111onCreateView");
		return view;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("01111111onCreate");
	}

	
}
