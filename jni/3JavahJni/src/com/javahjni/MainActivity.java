package com.javahjni;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	static {
		System.loadLibrary("hh");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void javahOnClick(View view) {
		Toast.makeText(this, getS(), 0).show();
	}
	
	public native String getS();
}
