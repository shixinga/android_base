package com.broadcast.ipcall;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et_number;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_number = (EditText) findViewById(R.id.et_number);
	}

	public void saveIPNumberOnClick(View view) {
		SharedPreferences sp = getSharedPreferences("ip", MODE_PRIVATE);
		sp.edit().putString("ipNumber", et_number.getText().toString()).commit();
	}
}
