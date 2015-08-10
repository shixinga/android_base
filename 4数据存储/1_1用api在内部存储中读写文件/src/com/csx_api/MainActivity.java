package com.csx_api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText ed_name;
	private EditText ed_password;
	private CheckBox cb_name_password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cb_name_password = (CheckBox) findViewById(R.id.cb_name_password);
		ed_name = (EditText) findViewById(R.id.ed_name);
		ed_password = (EditText) findViewById(R.id.ed_password);
		readAccount();
	}
	
	private void readAccount() {
		//读取在 data/data/com.csx.rom/info.txt 的文件
//		File file = new File("data/data/com.csx.rom/info.txt");
		
		//读取在 data/data/com.csx.rom/files/info.txt 的文件
//		File file = new File(getFilesDir(), "info.txt");

		
		//读取在 data/data/com.csx.rom/cache/info.txt 的文件
		File file = new File(getCacheDir(), "info.txt");
		if(file.exists()) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String line = bufferedReader.readLine();
				String []strs = line.split(",,");
				ed_name.setText(strs[0]);
				ed_password.setText(strs[1]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void login(View view) {
		if(cb_name_password.isChecked()) {
			//存储在 data/data/com.csx.rom/info.txt 文件中
//			File file = new File("data/data/com.csx.rom/info.txt");
	
			
			//读取在 data/data/com.csx.rom/files/info.txt 的文件
//			File file = new File(getFilesDir(), "info.txt");
	
			
			//读取在 data/data/com.csx.rom/cache/info.txt 的文件
			File file = new File(getCacheDir(), "info.txt");
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				String name = ed_name.getText().toString();
				String password = ed_password.getText().toString();
				fileOutputStream.write((name + ",," + password).getBytes());
				fileOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
