package com.service.ruyinji;

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

	public void startServiceOnClick(View view) {
		Intent intent = new Intent(this, TelephoneSoundRecorderService.class);
		startService(intent);
	}
}
