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
				Toast.makeText(MainActivity.this, "ͼƬ���سɹ�", 0).show();
				Bitmap bitmap = (Bitmap) msg.obj;
				iv_show.setImageBitmap(bitmap);
			} else {
				Toast.makeText(MainActivity.this, "����ʧ��", 0).show();
			}
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_show = (ImageView) findViewById(R.id.iv_show);
	}

	//�����������Ӷ���java����Դ����࣬������android��bitmap����android��
	public void getImageOnClick(View view) {
		new Thread() {

			@Override
			public void run() {
				//1.ͼƬ��ַ,192.168.1.19(���ʱ����wifi��ip)���ܱ��滻��localhost
				String path = "http://192.168.1.19:8080/2.jpg";
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
						//��ȡ����������ݣ��������λͼ����,����ģʽ!!
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
