package com.network.cacheimage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
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

	private static ImageView iv_show;
	//因为handle是static的，所以里面的属性都是static的
	static MainActivity ma;
	private static Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 0) {
				Bitmap bitmap = (Bitmap) msg.obj;
				iv_show.setImageBitmap(bitmap);
			} else {
				Toast.makeText(ma, "下载失败", 0).show();
			}
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_show = (ImageView) findViewById(R.id.iv_show);
		ma = this;
	}
	
	public void getImageOnclick(View view) {
		//1.图片地址,192.168.1.19(测的时候是wifi的ip)不能被替换成localhost
		final String path = "http://192.168.1.19:8080/2.jpg";
		final File file = new File(getFilesDir(), this.getFileName(path));
		//如果缓存中存在该文件（图片）
		if(file.exists()) {
			Message message = new Message();
			message.what = 0;
			String absoluteFilePath = file.getAbsolutePath();
			Bitmap bitmap = BitmapFactory.decodeFile(absoluteFilePath);
			iv_show.setImageBitmap(bitmap);
		} else {
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
							
							FileOutputStream fos = new FileOutputStream(file);
							byte [] buffer = new byte[1024];
							int n = 0;
							while((n = is.read(buffer)) != -1) {
								fos.write(buffer);
							}
							fos.close();
							//读取出流里的数据，并构造成位图对象
							//流里已经没有数据了
//							Bitmap bm = BitmapFactory.decodeStream(is);
							Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
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

	//通过路劲获取文件名
	private String getFileName(String path) {
		int index = path.lastIndexOf("/");
		return path.substring(index + 1);
	}
}
