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
		// ��ȡ��Activity�����TabHost���
		TabHost tabHost = getTabHost();
		LayoutInflater.from(this).inflate(R.layout.activity_main,
				tabHost.getTabContentView(), true);
		// ������һ��Tabҳ
		TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setIndicator("�ѽӵ绰")
				.setContent(R.id.tab01);
		// ��ӵ�һ����ǩҳ
		tabHost.addTab(tabSpec1);

		// �����ڶ���Tabҳ
		TabSpec tabSpec2 = tabHost
				.newTabSpec("tab2")
				// ע��R.drawable.icon,������R.id.icon
				.setIndicator("�����绰",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02);
		// ��ӵڶ�����ǩҳ
		tabHost.addTab(tabSpec2);

		// ������3��Tabҳ
		TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setIndicator("δ�ӵ绰")
				.setContent(R.id.tab03);
		// ��ӵڶ�����ǩҳ
		tabHost.addTab(tabSpec3);

	}

}
