package com.intenttabhost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 要继承TabActivity才能有getTabHost(),获取该Activity的TabHost组件
		TabHost tabHost = getTabHost();
		// 使用Intent添加第一个Tab页面
		tabHost.addTab(tabHost
				.newTabSpec("tab1")
				.setIndicator("已接电话",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(new Intent(this, BeCalledActivity.class)));
		// 使用Intent添加第二个Tab页面
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("呼出电话")
				.setContent(new Intent(this, CalledActivity.class)));
		// 使用Intent添加第三个Tab页面
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("未接电话")
				.setContent(new Intent(this, NoCalledActivity.class)));

	}
}
