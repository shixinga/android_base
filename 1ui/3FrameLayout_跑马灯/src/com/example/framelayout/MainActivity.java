package com.example.framelayout;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int currentColor = 0;
	// ����һ����ɫ����
	final int[] colors = new int[] { R.color.color7, R.color.color6,
			R.color.color5, R.color.color4, R.color.color3, R.color.color2,
			R.color.color1, };
	final int[] names = new int[] { R.id.View01, R.id.View02, R.id.View03,
			R.id.View04, R.id.View05, R.id.View06, R.id.View07 };
	TextView[] views = new TextView[7];

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < 7; i++) {
			views[i] = (TextView) findViewById(names[i]);
		}
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// ������Ϣ���Ա�����������
				if (msg.what == 0x1122) {
					// ���θı�7��TextView�ı���ɫ
					for (int i = 0; i < 7 - currentColor; i++) {
						views[i].setBackgroundResource(colors[i + currentColor]);
					}
					for (int i = 7 - currentColor, j = 0; i < 7; i++, j++) {
						views[i].setBackgroundResource(colors[j]);
					}
				}
				super.handleMessage(msg);
			}
		};
		// ����һ���߳������Եĸı�currentColor����ֵ
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				currentColor++;
				if (currentColor >= 6) {
					currentColor = 0;
				}
				// ����һ����Ϣ֪ͨϵͳ�ı�7��TextView����ı���ɫ
				Message m = new Message();
				// ������Ϣ����һ����ʶ
				m.what = 0x1122;
				handler.sendMessage(m);
			}
		}, 0, 100);
	}
}
