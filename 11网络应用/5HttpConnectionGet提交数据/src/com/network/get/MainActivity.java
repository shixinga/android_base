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
				Toast.makeText(MainActivity.this, "提交失败", 0).show();
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
				//2.把网址封装成一个url对象
				URL url;
				try {
					url = new URL(path);
					//3.获取客户端和服务器的连接对象，此时还没有建立连接
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					//4.对连接对象进行初始化
					//设置请求方法，注意大写
					conn.setRequestMethod("GET");
					//设置连接超时
					conn.setConnectTimeout(5000);
					//设置读取超时
					conn.setReadTimeout(5000);
					//5.发送请求，与服务器建立连接
					conn.connect();
					//如果响应码为200，说明请求成功
					if(conn.getResponseCode() == 200){
						//获取服务器响应头中的流，流里的数据就是客户端请求的数据
						InputStream is = conn.getInputStream();
						//读取服务器返回的流里的数据，把数据写到本地文件，缓存起来
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
