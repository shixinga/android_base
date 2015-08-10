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
	//��Ϊhandle��static�ģ�������������Զ���static��
	static MainActivity ma;
	private static Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 0) {
				Bitmap bitmap = (Bitmap) msg.obj;
				iv_show.setImageBitmap(bitmap);
			} else {
				Toast.makeText(ma, "����ʧ��", 0).show();
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
		//1.ͼƬ��ַ,192.168.1.19(���ʱ����wifi��ip)���ܱ��滻��localhost
		final String path = "http://192.168.1.19:8080/2.jpg";
		final File file = new File(getFilesDir(), this.getFileName(path));
		//��������д��ڸ��ļ���ͼƬ��
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
							
							FileOutputStream fos = new FileOutputStream(file);
							byte [] buffer = new byte[1024];
							int n = 0;
							while((n = is.read(buffer)) != -1) {
								fos.write(buffer);
							}
							fos.close();
							//��ȡ����������ݣ��������λͼ����
							//�����Ѿ�û��������
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

	//ͨ��·����ȡ�ļ���
	private String getFileName(String path) {
		int index = path.lastIndexOf("/");
		return path.substring(index + 1);
	}
}
