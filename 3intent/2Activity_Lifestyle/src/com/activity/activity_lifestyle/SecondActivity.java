package com.activity.activity_lifestyle;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("SecodActicity::onstart");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		System.out.println("SecodActicity::onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("SecodActicity::onResume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		System.out.println("SecodActicity::onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("SecodActicity::onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("SecodActicity::onDestroy");
	}

	
}
