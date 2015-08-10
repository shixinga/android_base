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
            
            //注册一个内容观察者，监听短信数据库内容的改变
            ContentResolver cr = getContentResolver();
            //uri:监听哪个uri上的内容提供者的通知
            //notifyForDescendents:如果是true，那么只要以content://sms开头的uri的数据改变，都能收到通知，比如content://sms/inbox
            cr.registerContentObserver(Uri.parse("content://sms"), true, new MyObserver(new Handler()));
        }
        
        class MyObserver extends ContentObserver{

    		public MyObserver(Handler handler) {
    			super(handler);
    			// TODO Auto-generated constructor stub
    		}
        	
    		//收到数据改变的通知，此方法调用
    		@Override
    		public void onChange(boolean selfChange) {
    			// TODO Auto-generated method stub
    			super.onChange(selfChange);
    			System.out.println("短信数据库改变");
    		}
    		
        }


}
