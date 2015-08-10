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
    	    	//ʹ��httpClient�����get��ʽ�ύ
    	    	//1.����HttpClient����
    	    	HttpClient hc = new DefaultHttpClient();
    	    	
    	    	//2.����httpGet���󣬹��췽���Ĳ���������ַ
    	    	HttpGet hg = new HttpGet(path);
    	    	
    	    	//3.ʹ�ÿͻ��˶��󣬰�get��������ͳ�ȥ
    	    	try {
    				HttpResponse hr = hc.execute(hg);
    				//�õ���Ӧͷ�е�״̬��
    				StatusLine sl = hr.getStatusLine();
    				if(sl.getStatusCode() == 200){
    					//�õ���Ӧͷ��ʵ��
    					HttpEntity he = hr.getEntity();
    					//�õ�ʵ���е����ݣ���ʵ���Ƿ��������ص�������
    					InputStream is = he.getContent();
    					String text = Utils.getStringByStream(is);
    					
    					//������Ϣ�������߳�ˢ��ui��ʾtext
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
    	    	//1.�����ͻ��˶���
    	    	HttpClient hc = new DefaultHttpClient();
    	    	//2.����post�������
    	    	HttpPost hp = new HttpPost(path);
    	    	
    	    	//��װform���ύ������
    	    	BasicNameValuePair bnvp = new BasicNameValuePair("name", name);
    	    	BasicNameValuePair bnvp2 = new BasicNameValuePair("password", password);
    	    	List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
    	    	//��BasicNameValuePair���뼯����
    	    	parameters.add(bnvp);
    	    	parameters.add(bnvp2);
    	    	
    	    	try {
    	    		//Ҫ�ύ�����ݶ��Ѿ��ڼ������ˣ��Ѽ��ϴ���ʵ�����
    		    	UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
    		    	//����post��������ʵ�壬��ʵ���ǰ�Ҫ�ύ�����ݷ�װ��post������������
    		    	hp.setEntity(entity);
    		    	//3.ʹ�ÿͻ��˷���post����
    				HttpResponse hr = hc.execute(hp);
    				if(hr.getStatusLine().getStatusCode() == 200){
    					InputStream is = hr.getEntity().getContent();
    					String text = Utils.getStringByStream(is);
    					
    					//������Ϣ�������߳�ˢ��ui��ʾtext
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
