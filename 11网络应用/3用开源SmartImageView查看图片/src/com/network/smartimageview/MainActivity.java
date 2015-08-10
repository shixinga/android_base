package com.network.smartimageview;

import com.loopj.android.image.SmartImageView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private SmartImageView siv_show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		siv_show = (SmartImageView) findViewById(R.id.siv_show);
	}

	public void getImageOnclick(View view) {
		//1.图片地址,192.168.1.19(测的时候是wifi的ip)不能被替换成localhost
		final String path = "http://192.168.1.19:8080/2.jpg";
		siv_show.setImageUrl(path);
	}
}
