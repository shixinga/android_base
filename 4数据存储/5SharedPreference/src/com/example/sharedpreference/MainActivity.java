package com.example.sharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_name;
	private EditText ed_password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_name = (EditText) findViewById(R.id.ed_name);
		ed_password = (EditText) findViewById(R.id.ed_password);
		readAccount();
	}
	
	private void readAccount() {
		//SharedPreferences use a xml file to save the data
		
		//create a xml file named "personInfo"+
		SharedPreferences sp = getSharedPreferences("personInfo", MODE_PRIVATE);
		String name = sp.getString("name", "");
		String password = sp.getString("password", "");
		ed_name.setText(name);
		ed_password.setText(password);
	}

	public void saveOnClick(View view) {
		SharedPreferences sp = getSharedPreferences("personInfo", MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("name", ed_name.getText().toString());
		editor.putString("password", ed_password.getText().toString());
		editor.commit();
		Toast.makeText(this, "save success", 0).show();
	}

}
