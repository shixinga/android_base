package com.activity.forresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NameActivity extends Activity {

	private ListView ll_show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name_content);
		ll_show = (ListView) findViewById(R.id.ll_show);
		final String[] names = {"陈帅哥", "小米", "小明"};
		ll_show.setAdapter(
				new ArrayAdapter<>(NameActivity.this, R.layout.item_view, R.id.tv_item, names));
	
		ll_show.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent();
				intent.putExtra("name", names[position]);
				//设置resultCode的值为1
				setResult(1, intent);
				finish();
			}
		});
	}
}
