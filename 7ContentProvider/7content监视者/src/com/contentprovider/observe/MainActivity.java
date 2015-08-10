package com.contentprovider.observe;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            
            //ע��һ�����ݹ۲��ߣ������������ݿ����ݵĸı�
            ContentResolver cr = getContentResolver();
            //uri:�����ĸ�uri�ϵ������ṩ�ߵ�֪ͨ
            //notifyForDescendents:�����true����ôֻҪ��content://sms��ͷ��uri�����ݸı䣬�����յ�֪ͨ������content://sms/inbox
            cr.registerContentObserver(Uri.parse("content://sms"), true, new MyObserver(new Handler()));
        }
        
        class MyObserver extends ContentObserver{

    		public MyObserver(Handler handler) {
    			super(handler);
    			// TODO Auto-generated constructor stub
    		}
        	
    		//�յ����ݸı��֪ͨ���˷�������
    		@Override
    		public void onChange(boolean selfChange) {
    			// TODO Auto-generated method stub
    			super.onChange(selfChange);
    			System.out.println("�������ݿ�ı�");
    		}
    		
        }


}
