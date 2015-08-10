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
		// Ҫ�̳�TabActivity������getTabHost(),��ȡ��Activity��TabHost���
		TabHost tabHost = getTabHost();
		// ʹ��Intent��ӵ�һ��Tabҳ��
		tabHost.addTab(tabHost
				.newTabSpec("tab1")
				.setIndicator("�ѽӵ绰",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(new Intent(this, BeCalledActivity.class)));
		// ʹ��Intent��ӵڶ���Tabҳ��
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("�����绰")
				.setContent(new Intent(this, CalledActivity.class)));
		// ʹ��Intent��ӵ�����Tabҳ��
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("δ�ӵ绰")
				.setContent(new Intent(this, NoCalledActivity.class)));

	}
}
