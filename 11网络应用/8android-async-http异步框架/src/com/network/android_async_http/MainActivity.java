package com.network.android_async_http;

import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends Activity {

	private EditText ed_name;
	private EditText ed_password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_name = (EditText) findViewById(R.id.ed_name);
		ed_password = (EditText) findViewById(R.id.ed_password);
		
	}

	public void getOnClick(View view) {
		String name = ed_name.getText().toString();
		String password = ed_password.getText().toString();
		AsyncHttpClient client = new AsyncHttpClient();
		
		String path = "http://192.168.1.100:8080/Server/LoginServlet?name=" + URLEncoder.encode(name) + "&password=" + password;
		client.get(path, new MyAsyncHttpResponseHandler());
		
	}
	public void postOnClick(View view) {
		String name = ed_name.getText().toString();
		String password = ed_password.getText().toString();
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams requestParams = new RequestParams();
		requestParams.put("name", name);
		requestParams.put("password", password);
		String path = "http://192.168.1.100:8080/Server/LoginServlet";
		client.post(path, requestParams, new MyAsyncHttpResponseHandler());
	}
	
	//这个父类所在的jar包是1.4.0版本的，不是最新也不是最旧
	//所以这些继承后必须override的方法一直在变，所以没有必要记住它！！
	class MyAsyncHttpResponseHandler extends AsyncHttpResponseHandler {


		//访问服务器失败（请求失败）时调用的方法
		@Override
		public void onFailure(Throwable arg0, String arg1) {
			Log.e("haaaa", arg1);
		}
		
		//访问服务器成功(是指网络请求成功)时调用的方法
		@Override
		public void onSuccess(String arg0) {
			Toast.makeText(MainActivity.this, arg0, 0).show();
		}

		
	}
}
