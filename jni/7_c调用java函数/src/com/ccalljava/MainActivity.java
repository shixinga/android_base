package com.ccalljava;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	static {
		System.loadLibrary("hi");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void cCallJavaOnClick(View view) {
		ccalljava();
	}
	public void showDialog(String message) {
		Builder builder = new Builder(this);
		builder.setTitle("БъЬт");
		builder.setMessage(message);
		builder.show();
	}
	public native void ccalljava();
}
