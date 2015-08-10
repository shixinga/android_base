package com.network.xutils.download;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

public class MainActivity extends Activity {

	private TextView tv_success;
	private TextView tv_fail;
	private TextView tv_percent;
	private ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_success = (TextView) findViewById(R.id.tv_success);
		tv_fail = (TextView) findViewById(R.id.tv_fail);
		tv_percent = (TextView) findViewById(R.id.tv_percent);
		pb = (ProgressBar) findViewById(R.id.pb);
	}

	public void downloadOnClick(View view) {
		HttpUtils http = new HttpUtils();
		HttpHandler handler = http.download("http://192.168.1.102:8080/2.jpg",
			getFilesDir() + "2.jpg",//�洢�ļ�·��
		    true, // ���Ŀ���ļ����ڣ�����δ��ɵĲ��ּ������ء���������֧��RANGEʱ���������ء�
		    true, // ��������󷵻���Ϣ�л�ȡ���ļ�����������ɺ��Զ���������
		    new RequestCallBack<File>() {


		        @Override
		        public void onLoading(long total, long current, boolean isUploading) {
//		            tv_percent.setText(current + "/" + total);
		        	pb.setMax((int)total);
					pb.setProgress((int)current);
		        	tv_percent.setText(current * 100 / total + "%");
		            
		        }

		        @Override
		        public void onSuccess(ResponseInfo<File> responseInfo) {
		            tv_success.setText("downloaded:" + responseInfo.result.getPath());
		        }


		        @Override
		        public void onFailure(HttpException error, String msg) {
		            tv_fail.setText(msg);
		        }
		});

	}
}
