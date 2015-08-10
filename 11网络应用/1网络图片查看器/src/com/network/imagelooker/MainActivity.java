package com.network.imagelooker;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv_show;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 0) {
				Toast.makeText(MainActivity.this, "图片加载成功", 0).show();
				Bitmap bitmap = (Bitmap) msg.obj;
				iv_show.setImageBitmap(bitmap);
			} else {
				Toast.makeText(MainActivity.this, "下载失败", 0).show();
			}
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_show = (ImageView) findViewById(R.id.iv_show);
	}

	//整个网络连接都是java类库自带的类，而不是android的bitmap才是android的
	public void getImageOnClick(View view) {
		new Thread() {

			@Override
			public void run() {
				//1.图片地址,192.168.1.19(测的时候是wifi的ip)不能被替换成localhost
				String path = "http://192.168.1.19:8080/2.jpg";
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
						//读取出流里的数据，并构造成位图对象,工厂模式!!
						Bitmap bitmap = BitmapFactory.decodeStream(is);
						Message message = new Message();
						message.obj = bitmap;
						message.what = 0;
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
