package com.processbar.calljava;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private ProgressBar pb;
	static {
		System.loadLibrary("hello");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pb = (ProgressBar) findViewById(R.id.pb);
		pb.setMax(100);
	}

	public void startProcessOnClick(View view) {
		new Thread() {

			@Override
			public void run() {
				
				startPb();
			}
			
		}.start();
	}
	
	public void stopProcessOnClick(View view) {
		stopPb();
	}
	
	public native void startPb();
	public native void stopPb();
	
	
	public void setProgressBar(int current) {
		pb.setProgress(current);
	}
}
