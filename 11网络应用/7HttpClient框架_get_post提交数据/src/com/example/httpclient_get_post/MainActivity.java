package com.example.httpclient_get_post;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.httpclient_get_post.util.Utils;

public class MainActivity extends Activity {

	private EditText ed_name;
	private EditText ed_password;
	static MainActivity ma;
	private static Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			Toast.makeText(ma, (String)msg.obj, 0).show();
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_name = (EditText) findViewById(R.id.ed_name);
		ed_password = (EditText) findViewById(R.id.ed_password);
		ma = this;
	}

	public void getOnClick(View view) {
		new Thread() {

			@Override
			public void run() {
				final String name = ed_name.getText().toString();
		    	final String password = ed_password.getText().toString();
		    	String path = "http://192.168.1.100:8080/Server/LoginServlet?name=" + URLEncoder.encode(name) + "&password=" + password;
    	    	//使用httpClient框架做get方式提交
    	    	//1.创建HttpClient对象
    	    	HttpClient hc = new DefaultHttpClient();
    	    	
    	    	//2.创建httpGet对象，构造方法的参数就是网址
    	    	HttpGet hg = new HttpGet(path);
    	    	
    	    	//3.使用客户端对象，把get请求对象发送出去
    	    	try {
    				HttpResponse hr = hc.execute(hg);
    				//拿到响应头中的状态行
    				StatusLine sl = hr.getStatusLine();
    				if(sl.getStatusCode() == 200){
    					//拿到响应头的实体
    					HttpEntity he = hr.getEntity();
    					//拿到实体中的内容，其实就是服务器返回的输入流
    					InputStream is = he.getContent();
    					String text = Utils.getStringByStream(is);
    					
    					//发送消息，让主线程刷新ui显示text
    					Message msg = handler.obtainMessage();
    					msg.obj = text;
    					handler.sendMessage(msg);
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
			}
			
		}.start();
		
	}
	
	public void postOnClick(View view) {
		new Thread() {
			
			@Override
			public void run() {
				final String name = ed_name.getText().toString();
		    	final String password = ed_password.getText().toString();
		    	String path = "http://192.168.1.100:8080/Server/LoginServlet";
    	    	//1.创建客户端对象
    	    	HttpClient hc = new DefaultHttpClient();
    	    	//2.创建post请求对象
    	    	HttpPost hp = new HttpPost(path);
    	    	
    	    	//封装form表单提交的数据
    	    	BasicNameValuePair bnvp = new BasicNameValuePair("name", name);
    	    	BasicNameValuePair bnvp2 = new BasicNameValuePair("password", password);
    	    	List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
    	    	//把BasicNameValuePair放入集合中
    	    	parameters.add(bnvp);
    	    	parameters.add(bnvp2);
    	    	
    	    	try {
    	    		//要提交的数据都已经在集合中了，把集合传给实体对象
    		    	UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
    		    	//设置post请求对象的实体，其实就是把要提交的数据封装至post请求的输出流中
    		    	hp.setEntity(entity);
    		    	//3.使用客户端发送post请求
    				HttpResponse hr = hc.execute(hp);
    				if(hr.getStatusLine().getStatusCode() == 200){
    					InputStream is = hr.getEntity().getContent();
    					String text = Utils.getStringByStream(is);
    					
    					//发送消息，让主线程刷新ui显示text
    					Message msg = handler.obtainMessage();
    					msg.obj = text;
    					handler.sendMessage(msg);
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
			}
			
		}.start();
		
	}
}
