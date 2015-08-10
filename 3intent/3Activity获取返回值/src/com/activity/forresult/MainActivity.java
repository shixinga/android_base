package com.activity.forresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et_name;
	private EditText et_content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_name = (EditText) findViewById(R.id.et_name);
		et_content = (EditText) findViewById(R.id.et_content);
	}
	public void getNameOnClick(View view) {
		Intent intent = new Intent(MainActivity.this, NameActivity.class);
		startActivityForResult(intent, 110);
	}
	
	public void getContentOnClick(View view) {
		Intent intent = new Intent(MainActivity.this, ContentActivity.class);
		startActivityForResult(intent, 222);
	}
	//如果有Activity在销毁时(注意是必须销毁且不用加startActivity函数)返回了数据，那么就会调用此方法来接收数据
		//requestCode:用来区分数据来自于哪一个Activity
		//resultCode:用来区分返回的数据是什么类型的
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 110) {
			if(resultCode == 1) {
				String name = data.getStringExtra("name");
				et_name.setText(name);
			}
		} else if(requestCode == 222) {
			if(resultCode == 2) {
				String content = data.getStringExtra("content");
				et_content.setText(content);
			}
		}
	}
	
	
} 
