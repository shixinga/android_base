package com.network.get;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.network.get.utils.Utils;

public class MainActivity extends Activity {

	private EditText ed_name;
	private EditText ed_password;
	protected Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 0) {
				String text = (String) msg.obj;
				Toast.makeText(MainActivity.this, text , 0).show();
			} else {
				Toast.makeText(MainActivity.this, "�ύʧ��", 0).show();
			}
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_name = (EditText) findViewById(R.id.ed_name);
		ed_password = (EditText) findViewById(R.id.ed_password);
	}

	public void loginOnClick(View view) {
		String name = ed_name.getText().toString();
		String password = ed_password.getText().toString();
		final String path = "http://192.168.1.19:8080/Server/LoginServlet?name=" + URLEncoder.encode(name) + "&password=" + password;
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
						handler .sendMessage(message);
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
