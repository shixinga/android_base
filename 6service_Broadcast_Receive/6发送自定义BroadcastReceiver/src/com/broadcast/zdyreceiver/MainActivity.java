package com.broadcast.zdyreceiver;

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
	}

	//��������Զ���㲥
	public void sendBroadcastOnClick(View view) {
		Intent intent = new Intent();
		intent.setAction("com.xxxx.broadcast");
		sendBroadcast(intent);
	}
}
