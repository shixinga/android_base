package com.network.post;

import java.io.InputStream;
import java.io.OutputStream;
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

import com.network.post.utils.Utils;

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
		final String name = ed_name.getText().toString();
		final String password = ed_password.getText().toString();
		final String path = "http://192.168.1.19:8080/Server/LoginServlet";
		new Thread() {

			@Override
			public void run() {
				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("POST");
					conn.setConnectTimeout(5000);
					conn.setReadTimeout(5000);
					
					//拼接出要提交的数据的字符串
					String data = "name=" + URLEncoder.encode(name) + "&password=" + password;
					//添加post请求的两行属性
					conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
					conn.setRequestProperty("Content-Length", data.length() + "");
					
					//设置打开输出流
					conn.setDoOutput(true);
					//拿到输出流
					OutputStream os = conn.getOutputStream();
					//使用输出流往服务器提交数据
					os.write(data.getBytes());
					if(conn.getResponseCode() == 200){
						InputStream is = conn.getInputStream();
						String text = Utils.getStringByInputStream(is);
						
						Message msg = handler.obtainMessage();
						msg.obj = text;
						handler.sendMessage(msg);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}.start();
	}
}
