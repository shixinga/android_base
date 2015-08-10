package com.example.tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// 获取该Activity里面的TabHost组件
		TabHost tabHost = getTabHost();
		LayoutInflater.from(this).inflate(R.layout.activity_main,
				tabHost.getTabContentView(), true);
		// 创建第一个Tab页
		TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setIndicator("已接电话")
				.setContent(R.id.tab01);
		// 添加第一个标签页
		tabHost.addTab(tabSpec1);

		// 创建第二个Tab页
		TabSpec tabSpec2 = tabHost
				.newTabSpec("tab2")
				// 注意R.drawable.icon,而不是R.id.icon
				.setIndicator("呼出电话",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02);
		// 添加第二个标签页
		tabHost.addTab(tabSpec2);

		// 创建第3个Tab页
		TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setIndicator("未接电话")
				.setContent(R.id.tab03);
		// 添加第二个标签页
		tabHost.addTab(tabSpec3);

	}

}
