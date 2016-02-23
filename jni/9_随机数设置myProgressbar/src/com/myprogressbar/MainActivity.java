package com.myprogressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private MyProgressBar mpb;
	static {
		System.loadLibrary("hi");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mpb = (MyProgressBar) findViewById(R.id.mpb);
	}

	public void startOnClick(View view) {
		new Thread() {

			@Override
			public void run() {
				startp();
			}
			
		}.start();
	}
	
	public void stopOnClick(View view) {
		stopp();
	}
	public native void startp();
	public native void stopp();
	
	public void setMyProgressBarData(int current) {
		mpb.setCurrentData(current);
	}
	
}
