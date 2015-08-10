package com.service.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent(this, BroadcastService.class);
	}

	public void startServiceOnClick(View view) {
		startService(intent);
	}
	
	public void stopServiceOnClick(View view) {
		stopService(intent);
	}
}
