package com.activity.forresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContentActivity extends Activity {

	private ListView ll_show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name_content);
		ll_show = (ListView) findViewById(R.id.ll_show);
		final String[] contents = {"肥沃的我i就", "你快回来", "bullshit ！asshole"};
		ll_show.setAdapter(
				new ArrayAdapter<>(ContentActivity.this, R.layout.item_view, R.id.tv_item, contents));
	
		ll_show.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent();
				intent.putExtra("content", contents[position]);
				//设置resultCode的值为1
				setResult(2, intent);
				finish();
			}
		});
	}
}
