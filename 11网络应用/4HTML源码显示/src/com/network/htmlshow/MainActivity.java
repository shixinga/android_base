package com.network.htmlshow;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.network.Utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static TextView tv_show;
	static MainActivity ma;
	private static Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 0) {
				String text = (String) msg.obj;
				tv_show.setText(text);
			} else {
				Toast.makeText(ma, "����ʧ��", 0).show();
			}
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_show = (TextView) findViewById(R.id.tv_show);
		ma = this;
	}

	public void getTextOnclick(View view) {
		final String path = "http://www.baidu.com";
		new Thread() {

			@Override
			public void run() {
				//2.����ַ��װ��һ��url����
				URL url;
				try {
					url = new URL(path);
					//3.��ȡ�ͻ��˺ͷ����������Ӷ��󣬴�ʱ��û�н�������
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					//4.�����Ӷ�����г�ʼ��
					//�������󷽷���ע���д
					conn.setRequestMethod("GET");
					//�������ӳ�ʱ
					conn.setConnectTimeout(5000);
					//���ö�ȡ��ʱ
					conn.setReadTimeout(5000);
					//5.�����������������������
					conn.connect();
					//�����Ӧ��Ϊ200��˵������ɹ�
					if(conn.getResponseCode() == 200){
						//��ȡ��������Ӧͷ�е�������������ݾ��ǿͻ������������
						InputStream is = conn.getInputStream();
						//��ȡ���������ص���������ݣ�������д�������ļ�����������
						String text = Utils.getStringByInputStream(is);
						Message message = new Message();
						message.what = 0;
						message.obj = text;
						handler.sendMessage(message);
					} else {
						handler.sendEmptyMessage(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
					handler.sendEmptyMessage(1);
				}
			}
			
		}.start();
	}
}
