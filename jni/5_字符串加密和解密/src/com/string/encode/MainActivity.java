package com.string.encode;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editText;
	static {
		System.loadLibrary("Hi");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.ed_password);
	}
	
	public void encodeOnClick(View view) {
		String str = editText.getText().toString();
		int length = str.length();
		String encodePassword = encode(str, length); 
		editText.setText(encodePassword);
	}

	public void decodeOnClick(View view) {
		String str = editText.getText().toString();
		int length = str.length();
		String decodePassword = decode(str, length); 
		editText.setText(decodePassword);
	}
	
	public native String encode(String str, int length);
	public native String decode(String str, int length);
}
