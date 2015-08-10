package com.gridlayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends Activity {

	GridLayout gridLayout;
	String []chars = new String[]{
	"7","8","9","/",

	"4","5","6","*",

	"1","2","3","-",
	".","0","=","+"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridLayout = (GridLayout) findViewById(R.id.root);
		for(int i = 0; i < chars.length; ++i) {
			Button button = new Button(this);
			button.setText(chars[i]);
			//���ð�ť�Ĵ�С
			button.setTextSize(40);
			//ָ����������ڵ���
			GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
			//ָ����������ڵ���
			GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
			GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
			//ָ�������ռ��������
			params.setGravity(Gravity.FILL);
			gridLayout.addView(button, params);
		}
	}
}
