package com.activity.activity_lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("MainActivity::oncreate");
	}

	
	public void startSecondActivityOnClick(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);
	}
	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("MainActivity::onstart");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		System.out.println("MainActivity::onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("MainActivity::onResume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		System.out.println("MainActivity::onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("MainActivity::onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("MainActivity::onDestroy");
	}
}
