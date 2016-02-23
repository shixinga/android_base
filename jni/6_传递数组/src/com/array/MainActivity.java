package com.array;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	int arr[] = {1,2,3,4,5};
	static {
		System.loadLibrary("hello");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(this, arr[0] + "," + arr[1] +","+ arr[2] +","+ arr[3] +","+ arr[4] + "..", 0).show();
	}

	public void passArrayOnClick(View view) {
		passArray(arr);
		Toast.makeText(this, arr[0] + "," + arr[1] +","+ arr[2] +","+ arr[3] +","+ arr[4] + "..", 0).show();
		
	}
	
	public native void passArray(int [] arr);
}
